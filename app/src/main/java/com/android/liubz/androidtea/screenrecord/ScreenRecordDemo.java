package com.android.liubz.androidtea.screenrecord;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.liubz.androidtea.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ScreenRecordDemo extends Activity {
	private static final String TAG = "ScreenRecordDemo";

	public static final int STATUS_IDLE = 0;
	public static final int STATUS_RECORDING = 1;
	public static final int STATUS_PROCESSING = 2;
	public static final int STATUS_ERROR = -1;

	private static final int MSG_TASK_ENDED = 1;
	private static final int MSG_TASK_ERROR = 2;
	private static final String TMP_PATH = "/sdcard/__tmp_screenrecord.mp4";

	private int mRecordingStatus;
	private CaptureThread mCaptureThread;
	private Handler mHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screen_record_demo);

		mHandler = new Handler() {
			public void handleMessage(Message msg) {
				if (msg.what == MSG_TASK_ENDED) {
					// The screenrecord process stopped, act as if user
					// requested the record to stop.
					stopScreenrecord();
				} else if (msg.what == MSG_TASK_ERROR) {
					mCaptureThread = null;
					updateStatus(STATUS_ERROR, (String) msg.obj);
					Toast.makeText(ScreenRecordDemo.this,
							"录屏失败", Toast.LENGTH_SHORT).show();
				}
			}
		};

		mRecordingStatus = STATUS_IDLE;

	}


	public void toggleRecord(View view) {
		if (isRecording()) {
			stopScreenrecord();
		} else {
			startScreenrecord();
		}
	}

	private void startScreenrecord() {
		if (!isScreenrecordSupported()) {
			Log.e(TAG, "startScreenrecord: System does not support screen recording");
			Toast.makeText(this, "Your system does not support screen recording", Toast.LENGTH_SHORT).show();
			return;
		}
		if (isRecording()) {
			Log.e(TAG, "startScreenrecord: Recording is already running, ignoring screenrecord start request");
			return;
		} else if (isProcessing()) {
			Log.e(TAG, "startScreenrecord: Previous recording is still being processed, " +
					"ignoring screenrecord start request");
			Toast.makeText(this, "正在处理", Toast.LENGTH_SHORT).show();
			return;
		}

		mCaptureThread = new CaptureThread();
		mCaptureThread.start();
		updateStatus(STATUS_RECORDING);
	}

	private void stopScreenrecord() {
		if (!isRecording()) {
			Log.e(TAG, "Cannot stop recording that's not active");
			return;
		}
		updateStatus(STATUS_PROCESSING);

		try {
			mCaptureThread.interrupt();
		} catch (Exception e) { /* ignore */ }

		// Wait a bit for capture thread to finish
		while (mCaptureThread.isAlive()) {
			// wait...
		}

		// Give a second to screenrecord to process the file
		mHandler.postDelayed(() -> {
			mCaptureThread = null;

			String fileName = "SCR_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date()) + ".mp4";

			File picturesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			if (!picturesDir.exists()) {
				if (!picturesDir.mkdir()) {
					Log.e(TAG, "Cannot create Pictures directory");
					return;
				}
			}

			File screenrecord = new File(picturesDir, "Screenrecord");
			if (!screenrecord.exists()) {
				if (!screenrecord.mkdir()) {
					Log.e(TAG, "Cannot create Screenrecord directory");
					return;
				}
			}

			File input = new File(TMP_PATH);
			final File output = new File(screenrecord, fileName);

			Log.d(TAG, "Copying file to " + output.getAbsolutePath());

			try {
				copyFileUsingStream(input, output);
				input.delete();
				Toast.makeText(this, "保存到" + output.getPath(), Toast.LENGTH_SHORT).show();
			} catch (IOException e) {
				Log.e(TAG, "Unable to copy output file", e);
				Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT).show();
			}

			// Make it appear in gallery, run MediaScanner
			MediaScannerConnection.scanFile(this,
					new String[] { output.getAbsolutePath() }, null,
					(path, uri) -> Log.i(TAG, "MediaScanner done scanning " + path));
			updateStatus(STATUS_IDLE);
		}, 3000);
	}

	private static void copyFileUsingStream(File source, File dest) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
		}
	}

	private boolean isScreenrecordSupported() {
		// check if screenrecord and kill binaries exist and are executable
		File f = new File(getBinaryPath());
		final boolean scrBinaryOk = f.exists() && f.canExecute();
		if (!scrBinaryOk) {
			Log.e(TAG, "isScreenrecordSupported: screenrecord binary doesn't exist or is not executable");
		}
		f = new File("/system/bin/kill");
		final boolean killBinaryOk = f.exists() && f.canExecute();
		if (!killBinaryOk) {
			Log.e(TAG, "isScreenrecordSupported: kill binary doesn't exist or is not executable");
		}
		return (scrBinaryOk && killBinaryOk);
	}

	private String getBinaryPath() {
		return "/system/bin/screenrecord";
	}

	private boolean isRecording() {
		return (mRecordingStatus == STATUS_RECORDING);
	}

	private boolean isProcessing() {
		return (mRecordingStatus == STATUS_PROCESSING);
	}

	private void updateStatus(int status) {
		updateStatus(status, null);
	}

	private void updateStatus(int status, String message) {
		mRecordingStatus = status;
	}

	private class CaptureThread extends Thread {
		public void run() {
			try {
				// Firstly, make sure we are able to get to pid field of ProcessImpl class
//				final Class<?> classProcImpl = Class.forName("java.lang.ProcessManager$ProcessImpl");
//				final Field fieldPid = classProcImpl.getDeclaredField("pid");
//				fieldPid.setAccessible(true);

				// choose screenrecord binary and prepare command
				List<String> command = new ArrayList<>();
				command.add("su");
				command.add("-c");
				command.add(getBinaryPath());
				Log.i(TAG, "run: path: " + TMP_PATH);
				command.add(TMP_PATH);

				// construct and start the process
				ProcessBuilder pb = new ProcessBuilder();
				pb.command(command);
				pb.redirectErrorStream(true);
				Process proc = pb.start();
				Thread.sleep(5000);
				proc.destroy();

				// Get process PID to be used with native kill later
//				final int pid = fieldPid.getInt(proc);
//				Log.d(TAG, "Screenrecord PID = " + pid);


				// Terminate the recording process
//				Runtime.getRuntime().exec(new String[]{ "kill", "-2", String.valueOf(pid) });
			} catch (Exception e) {
				// Notify something went wrong
				Message msg = Message.obtain(mHandler, MSG_TASK_ERROR, 0, 0, e.getMessage());
				mHandler.sendMessage(msg);

				// Log the error as well
				Log.e(TAG, "Error while starting the screenrecord process", e);
			}
		}
	}
}
