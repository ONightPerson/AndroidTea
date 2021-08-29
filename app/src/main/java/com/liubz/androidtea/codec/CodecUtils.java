package com.liubz.androidtea.codec;

import android.content.res.AssetFileDescriptor;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

/**
 * author: liubaozhu
 * time:   2021/8/28
 */
public class CodecUtils {
    private static final String TAG = "CodecUtils";

    public static int selectTrack(MediaExtractor extractor) {
        if (extractor == null) {
            return -1;
        }
        int numTracks = extractor.getTrackCount();
        for (int i = 0; i < numTracks; i++) {
            MediaFormat format = extractor.getTrackFormat(i);
            if (format == null) {
                continue;
            }
            String mime = format.getString(MediaFormat.KEY_MIME);
            Log.i(TAG, "selectTrack: mime: " + mime);
            if (mime == null) {
                continue;
            }
            // 获取第一帧视频帧
            if (mime.startsWith("video/")) {
                return i;
            }
        }
        return -1;
    }

    public static void showSupportedColorFormat(MediaCodecInfo.CodecCapabilities caps) {
        StringBuilder builder = new StringBuilder();
        for (int c : caps.colorFormats) {
            builder.append(c).append("\t");
        }
        Log.i(TAG, "showSupportedColorFormat: support format:" + builder.toString());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void showSupportedColorFormat(AssetFileDescriptor afd) throws Exception {
        // MediaExtractor 用于从数据源中提取解复用的、通常是编码的媒体数据。
        MediaExtractor extractor = new MediaExtractor();
        // 设置数据源
        extractor.setDataSource(afd);
        // 获取视频所在的轨道号
        int trackIndex = selectTrack(extractor);
        Log.i(TAG, "showSupportedColorFormat: trackIndex: " + trackIndex);
        if (trackIndex < 0) {
            throw new RuntimeException("No video track found in " + afd);
        }
        extractor.selectTrack(trackIndex);
        MediaFormat mediaFormat = extractor.getTrackFormat(trackIndex);
        String mime = mediaFormat.getString(MediaFormat.KEY_MIME);
        MediaCodec decoder = MediaCodec.createDecoderByType(mime);
        showSupportedColorFormat(decoder.getCodecInfo().getCapabilitiesForType(mime));

        int videoWidth = mediaFormat.getInteger(MediaFormat.KEY_WIDTH);
        int videoHeight = mediaFormat.getInteger(MediaFormat.KEY_HEIGHT);
        Log.i(TAG, "showSupportedColorFormat: width: " + videoWidth + ", height: " + videoHeight);
    }
}
