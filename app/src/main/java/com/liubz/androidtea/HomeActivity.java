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

import com.liubz.androidtea.anim.AnimActivity;
import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.binderpool.BinderPoolActivity;
import com.liubz.androidtea.broadcast.SimStateReceiver;
import com.liubz.androidtea.communicate.CommunicationActivity;
import com.liubz.androidtea.container.ContainerActivity;
import com.liubz.androidtea.contentprovider.BookProviderTestActivity;
import com.liubz.androidtea.databinding.ActivityHomeBinding;
import com.liubz.androidtea.expandablelist.MyExpandableListActivity;
import com.liubz.androidtea.imageloader.GlideActivity;
import com.liubz.androidtea.immersive.ImmersiveActivity;
import com.liubz.androidtea.material.ConstraintDemoActivity;
import com.liubz.androidtea.network.HttpRequestTestActivity;
import com.liubz.androidtea.network.WebViewTestActivity;
import com.liubz.androidtea.network.retrofit.page.RetrofitActivity;
import com.liubz.androidtea.network.socket.SocketTestActivity;
import com.liubz.androidtea.notification.NewTaskActivity;
import com.liubz.androidtea.repo.RepoActivity;
import com.liubz.androidtea.rx.RxActivity;
import com.liubz.androidtea.stack.launchmode.DialogActivity;
import com.liubz.androidtea.stack.launchmode.LaunchModeActivity;
import com.liubz.androidtea.stack.launchmode.TransparentActivity;
import com.liubz.androidtea.utils.CommonDialog;
import com.liubz.androidtea.utils.NdkUtils;
import com.liubz.androidtea.utils.ReflectionUtils;
import com.liubz.androidtea.utils.ScreenUtils;
import com.liubz.androidtea.utils.SpannableStringBuilderUtil;
import com.liubz.androidtea.utils.StatusBarUtil;
import com.liubz.androidtea.utils.UrlUtils;
import com.liubz.androidtea.view.EditTextActivity;
import com.liubz.androidtea.view.GestureDetectorActivity;
import com.liubz.androidtea.view.VelocityTrackerActivity;
import com.liubz.androidtea.view.ViewStubActivity;
import com.liubz.androidtea.window.WindowActivity;

public class HomeActivity extends BaseActivity {
    private static final String TAG = "HomeActivity";
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("HomeActivity");
        Log.i(TAG, "onCreate");

        initListeners();
    }

    private void initListeners() {
        binding.constraintDemo.setOnClickListener(v -> launchConstraintDemo());
        binding.expandableListActivity.setOnClickListener(v -> launchExpandableListActivity());
        binding.editTextActivity.setOnClickListener(v -> launchEditTextActivity());
        binding.launchWebview.setOnClickListener(v -> launchWebview());
        binding.retrofitActivity.setOnClickListener(v -> startRetrofitActivity());
        binding.callPhone.setOnClickListener(v -> callPhone());
        binding.launchBrowser.setOnClickListener(v -> launchBrowser());
        binding.rxJava3Activity.setOnClickListener(v -> launchRxActivity());
        binding.classloader.setOnClickListener(v -> classLoader());
        binding.goToOtherAppActivity.setOnClickListener(v -> goToSecondActivity());
        binding.containerActivity.setOnClickListener(v -> goContainerActivity());
        binding.communicateActivity.setOnClickListener(v -> goCommunicateActivity());
        binding.launchLaunchMode.setOnClickListener(v -> launchLaunchModeActivity());
        binding.launchNewTask.setOnClickListener(v -> launchNewTask());
        binding.launchModeTransparentBtn.setOnClickListener(v -> launchTransparentActivity());
        binding.launchModeDialogActivityBtn.setOnClickListener(v -> launchDialogActivity());
        binding.immersivePage.setOnClickListener(v -> launchImmersiveActivity());
        binding.getStatusBarHeight.setOnClickListener(v -> getStatusBarHeight());
        binding.showAlertDialog.setOnClickListener(v -> showDialog());
        binding.glideActivity.setOnClickListener(v -> goGlideActivity());
        binding.gsonTest.setOnClickListener(v -> startHttpRequestActivity());
        binding.screenInfo.setOnClickListener(v -> outputScreenInfo());
        binding.ndkTools.setOnClickListener(v -> ndkTools());
        binding.simStateListener.setOnClickListener(v -> simStateListener());
        binding.viewStub.setOnClickListener(v -> viewStub());
        binding.dialogTest.setOnClickListener(v -> dialogTest());
        binding.repoTest.setOnClickListener(v -> repoActivity());
        binding.reflectionDemo.setOnClickListener(v -> reflectionDemo());
        binding.anim.setOnClickListener(v -> anim());
        binding.windowDemo.setOnClickListener(v -> windowDemo());
        binding.bookProviderTest.setOnClickListener(v -> launchBookProviderTest());
        binding.socketTest.setOnClickListener(v -> launchSocketTest());
        binding.binderPoolTest.setOnClickListener(v -> launchBinderPoolTest());
        binding.velocityTrackerTest.setOnClickListener(v -> launchVelocityTrackerTest());
        binding.gestureDetectorTest.setOnClickListener(v -> gestureDetectorTest());
    }

    private void launchConstraintDemo() {
        startActivity(new Intent(this, ConstraintDemoActivity.class));
    }

    private void launchExpandableListActivity() {
        startActivity(new Intent(this, MyExpandableListActivity.class));
    }

    private void launchEditTextActivity() {
        startActivity(new Intent(this, EditTextActivity.class));
    }

    private void launchWebview() {
        Intent intent = new Intent(this, WebViewTestActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void startRetrofitActivity() {
        startActivity(new Intent(this, RetrofitActivity.class));
    }

    private void callPhone() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:17611490712"));
        startActivity(intent);
    }

    private void launchBrowser() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void launchRxActivity() {
        startActivity(new Intent(this, RxActivity.class));
    }

    private void classLoader() {
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

    private void goToSecondActivity() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.learnopengles.android",
          "com.learnopengles.android.lesson_OpenGL_ES_2.TriangleActivity"));
        startActivity(intent);
    }

    private void goContainerActivity() {
        startActivity(new Intent(this, ContainerActivity.class));
    }

    private void goCommunicateActivity() {
        startActivity(new Intent(this, CommunicationActivity.class));
    }

    private void launchLaunchModeActivity() {
        Intent intent = new Intent(this, LaunchModeActivity.class);
        startActivity(intent);
    }

    private void launchNewTask() {
        Intent intent = new Intent(this, NewTaskActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void launchTransparentActivity() {
        startActivity(new Intent(this, TransparentActivity.class));
    }

    private void launchDialogActivity() {
        startActivity(new Intent(this, DialogActivity.class));
    }

    private void launchImmersiveActivity() {
        Intent intent = new Intent(this, ImmersiveActivity.class);
        startActivity(intent);
    }

    private void getStatusBarHeight() {
        Toast.makeText(HomeActivity.this, "状态栏高度：" + StatusBarUtil.getStatusBarHeight(this), Toast.LENGTH_LONG).show();
    }

    private void showDialog() {
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

    private void goGlideActivity() {
        startActivity(new Intent(this, GlideActivity.class));
    }

    private void startHttpRequestActivity() {
        startActivity(new Intent(this, HttpRequestTestActivity.class));
    }

    private void outputScreenInfo() {
        ScreenUtils.outputDensityInfo(this);
    }

    private void ndkTools() {
        String contentFromJni = NdkUtils.getStringFromNdk();
        Log.i(TAG, "ndkTools: contentFromJni: " + contentFromJni);
    }

    private void simStateListener() {
        SimStateReceiver simStateReceiver = new SimStateReceiver();
        IntentFilter intentFilter = new IntentFilter(SimStateReceiver.ACTION_SIM_STATE_CHANGED);
        registerReceiver(simStateReceiver, intentFilter);
    }

    private void viewStub() {
        startActivity(new Intent(this, ViewStubActivity.class));
    }

    private void dialogTest() {
        SpannableStringBuilder info = new SpannableStringBuilder();
        info.append("请点击");
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
        SpannableStringBuilderUtil.append(info,"快递单号",
          false, getResources().getColor(R.color.orange_font), serviceClickableSpan);
        info.append("来查看的你的物流信息");
        CommonDialog dialog = new CommonDialog(this);
        dialog.title("测试弹窗")
          .content(info)
          .positiveBtnText("确定")
          .onPositiveBtnClick(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Toast.makeText(HomeActivity.this, "确定", Toast.LENGTH_SHORT).show();
                  dialog.dismiss();
              }
          })
          .negativeBtnText("取消")
          .onNegativeBtnClick(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  dialog.dismiss();
              }
          })
          .show();
    }

    private void repoActivity() {
        startActivity(new Intent(this, RepoActivity.class));
        String originalUrl = "https://example.com/path/to/resource?param1=value1&param2=value2#section1";
        String urlWithoutParamsAndHash = UrlUtils.removeUrlParametersAndHash(originalUrl);
        Log.i(TAG, "repoActivity: URL without parameters and hash: " + urlWithoutParamsAndHash);
    }

    private void reflectionDemo() {
        try {
            ReflectionUtils.test();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private void anim() {
        startActivity(new Intent(this, AnimActivity.class));
    }

    private void windowDemo() {
        startActivity(new Intent(this, WindowActivity.class));
    }

    private void launchBookProviderTest() {
        startActivity(new Intent(this, BookProviderTestActivity.class));
    }

    private void launchSocketTest() {
        startActivity(new Intent(this, SocketTestActivity.class));
    }

    private void launchBinderPoolTest() {
        startActivity(new Intent(this, BinderPoolActivity.class));
    }

    private void launchVelocityTrackerTest() {
        startActivity(new Intent(this, VelocityTrackerActivity.class));
    }

    private void gestureDetectorTest() {
        startActivity(new Intent(this, GestureDetectorActivity.class));
    }
}
