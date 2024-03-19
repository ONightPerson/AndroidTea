package com.liubz.androidtea;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.baseinterface.BaseInterface;
import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.broadcast.SimStateReceiver;
import com.liubz.androidtea.communicate.CommunicationActivity;
import com.liubz.androidtea.container.ContainerActivity;
import com.liubz.androidtea.expandablelist.MyExpandableListActivity;
import com.liubz.androidtea.imageloader.GlideActivity;
import com.liubz.androidtea.immersive.ImmersiveActivity;
import com.liubz.androidtea.network.HttpRequestTestActivity;
import com.liubz.androidtea.network.WebViewTestActivity;
import com.liubz.androidtea.network.retrofit.page.RetrofitActivity;
import com.liubz.androidtea.notification.NewTaskActivity;
import com.liubz.androidtea.rx.RxActivity;
import com.liubz.androidtea.stack.launchmode.DialogActivity;
import com.liubz.androidtea.stack.launchmode.LaunchModeActivity;
import com.liubz.androidtea.stack.launchmode.TransparentActivity;
import com.liubz.androidtea.utils.CommonDialog;
import com.liubz.androidtea.utils.NdkUtils;
import com.liubz.androidtea.utils.ScreenUtils;
import com.liubz.androidtea.utils.SpannableStringBuilderUtil;
import com.liubz.androidtea.utils.StatusBarUtil;
import com.liubz.androidtea.view.EditTextActivity;
import com.liubz.androidtea.view.ViewStubActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {
    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("HomeActivity");
        ButterKnife.bind(this);
        Log.i(TAG, "onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @OnClick(R.id.expandable_list_activity)
    void launchExpandableListActivity() {
        startActivity(new Intent(this, MyExpandableListActivity.class));
    }

    @OnClick(R.id.edit_text_activity)
    void launchEditTextActivity() {
        startActivity(new Intent(this, EditTextActivity.class));
    }

    @OnClick(R.id.launch_webview)
    void onClick() {
        Intent intent = new Intent(this, WebViewTestActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @OnClick(R.id.retrofit_activity)
    void startRetrofitActivity() {
        startActivity(new Intent(this, RetrofitActivity.class));
    }

    @OnClick(R.id.call_phone)
    void callPhone() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:17611490712"));
        startActivity(intent);
    }

    @OnClick(R.id.launch_browser)
    void launchBrowser() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @OnClick(R.id.rx_java3_activity)
    void launchRxActivity() {
        startActivity(new Intent(this, RxActivity.class));
    }

    @OnClick(R.id.service_loader)
    void serviceLoader() {
        try {
            Enumeration<URL> enumeration = Thread.currentThread().getContextClassLoader().getResources("META-INF/services/" + BaseInterface.class.getName());
            Log.i(TAG, "serviceLoader: enumeration: " + enumeration);
//            Log.i(TAG, "serviceLoader: hasMoreElements: " + enumeration.hasMoreElements());
//            URL nextElement = enumeration.nextElement();
//            Log.i(TAG, "serviceLoader: next Element: " + nextElement);
            Iterator<String> pending = null;
            while ((pending == null) || !pending.hasNext()) {
                if (!enumeration.hasMoreElements()) {
                    return;
                }
                pending = parse(BaseInterface.class, enumeration.nextElement());
                Log.i(TAG, "serviceLoader: pending: " + pending + ", hasNext: " + pending.hasNext());
            }
            Log.i(TAG, "serviceLoader: parse result: " + pending.next());
//            while (enumeration.hasMoreElements()) {
//                Log.i(TAG, "serviceLoader: elements: " + enumeration.nextElement());
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.classloader)
    void classLoader() {

        String classpath, bootPath, extPath;

        try {
            classpath = System.getProperty("java.class.path");
            bootPath = System.getProperty("sun.boot.class.path");
            extPath = System.getProperty("java.ext.dirs");
            Log.i(TAG, "classLoader-classpath: " + classpath + ", bootPath: " + bootPath + ", extPath: " + extPath);
        } catch (SecurityException e) {
        }

        ClassLoader loader = HomeActivity.class.getClassLoader();
        while (loader != null) {
            Log.i(TAG, "classLoader: " + loader);
            loader = loader.getParent();
        }

    }

    @OnClick(R.id.go_to_other_app_activity)
    void goToSecondActivity() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.learnopengles.android",
          "com.learnopengles.android.lesson_OpenGL_ES_2.TriangleActivity"));
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @OnClick(R.id.container_activity)
    void goContainerActivity() {
        startActivity(new Intent(this, ContainerActivity.class));
    }

    @OnClick(R.id.communicate_activity)
    void goCommunicateActivity() {
        startActivity(new Intent(this, CommunicationActivity.class));
    }

    private Iterator<String> parse(Class<?> service, URL u)
      throws ServiceConfigurationError {
        Log.i(TAG, "parse: service: " + service + ", url: " + u);
        InputStream in = null;
        BufferedReader r = null;
        ArrayList<String> names = new ArrayList<>();
        try {
            in = u.openStream();
            r = new BufferedReader(new InputStreamReader(in, "utf-8"));
            int lc = 1;
            while ((lc = parseLine(service, u, r, lc, names)) >= 0) ;
        } catch (IOException x) {
            Log.e(TAG, "parse: exception", x);
        } finally {
            try {
                if (r != null) r.close();
                if (in != null) in.close();
            } catch (IOException y) {
            }
        }
        return names.iterator();
    }

    @OnClick(R.id.launch_launch_mode)
    void launchLaunchModeActivity() {
        Intent intent = new Intent(this, LaunchModeActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.launch_new_task)
    void launchNewTask() {
        Intent intent = new Intent(this, NewTaskActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @OnClick(R.id.launch_mode_transparent_btn)
    void launchTransparentActivity() {
        startActivity(new Intent(this, TransparentActivity.class));
    }

    @OnClick(R.id.launch_mode_dialog_activity_btn)
    void launchDialogActivity() {
        startActivity(new Intent(this, DialogActivity.class));
    }

    @OnClick(R.id.immersive_page)
    void launchImmersiveActivity() {
        Intent intent = new Intent(this, ImmersiveActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.get_status_bar_height)
    void getStatusBarHeight() {
        Toast.makeText(HomeActivity.this, "状态栏高度：" + StatusBarUtil.getStatusBarHeight(this), Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.show_alert_dialog)
    void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dialog = builder.setTitle("欢迎来到Android世界")
          .setMessage("这个是一个AlertDialog")
          .setCancelable(true)
          .setPositiveButton("确认", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  dialog.dismiss();
              }
          })
          .setNegativeButton("取消", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  dialog.dismiss();
              }
          })
          .setOnCancelListener(new DialogInterface.OnCancelListener() {
              @Override
              public void onCancel(DialogInterface dialog) {
                  Log.i(TAG, "AlertDialog onCancel");
              }
          })
          .create();
        dialog.show();
    }

    @OnClick(R.id.glide_activity)
    void goGlideActivity() {
        startActivity(new Intent(this, GlideActivity.class));
    }

    private int parseLine(Class<?> service, URL u, BufferedReader r, int lc,
                          List<String> names)
      throws IOException, ServiceConfigurationError {
        String ln = r.readLine();
        if (ln == null) {
            return -1;
        }
        int ci = ln.indexOf('#');
        if (ci >= 0) ln = ln.substring(0, ci);
        ln = ln.trim();
        int n = ln.length();
        if (n != 0) {
            if ((ln.indexOf(' ') >= 0) || (ln.indexOf('\t') >= 0)) {
                //                fail(service, u, lc, "Illegal configuration-file syntax");
            }
            int cp = ln.codePointAt(0);
            if (!Character.isJavaIdentifierStart(cp))
                for (int i = Character.charCount(cp); i < n; i += Character.charCount(cp)) {
                    cp = ln.codePointAt(i);
                    if (!Character.isJavaIdentifierPart(cp) && (cp != '.')) {

                    }
                }
            names.add(ln);
        }
        return lc + 1;
    }

    @OnClick(R.id.gson_test)
    void startHttpRequestActivity() {
        startActivity(new Intent(this, HttpRequestTestActivity.class));
    }

    @OnClick(R.id.screen_info)
    void outputScreenInfo() {
        ScreenUtils.outputDensityInfo(this);
    }

    @OnClick(R.id.ndk_tools)
    void ndkTools() {
        String contentFromJni = NdkUtils.getStringFromNdk();
        Log.i(TAG, "ndkTools: contentFromJni: " + contentFromJni);
    }

    @OnClick(R.id.sim_state_listener)
    void simStateListener() {
        SimStateReceiver simStateReceiver = new SimStateReceiver();
        IntentFilter intentFilter = new IntentFilter(SimStateReceiver.ACTION_SIM_STATE_CHANGED);
        registerReceiver(simStateReceiver, intentFilter);
    }

    @OnClick(R.id.view_stub)
    void viewStub() {
        startActivity(new Intent(this, ViewStubActivity.class));
    }

    @OnClick(R.id.dialog_test)
    void dialogTest() {
        SpannableStringBuilder info = new SpannableStringBuilder();
        info.append("hfefefefe");
        ClickableSpan serviceClickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                //页面跳转到《用户协议》页面
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                //移除下划线
                ds.setUnderlineText(false);
            }
        };
        SpannableStringBuilderUtil.append(info,"\n用户协议",
          false, getResources().getColor(R.color.orange_font), serviceClickableSpan);
        CommonDialog dialog = new CommonDialog(this);
        dialog.title("hffff")
          .content(info)
          .positiveBtnText("hfefefefe")
          .show();
    }
}
