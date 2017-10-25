package com.cjt.pluginlib;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

/**
 * =====================================
 * 作    者: 陈嘉桐
 * 创建日期：2017/10/25
 * 描    述：
 * =====================================
 */
public interface PluginInterface {
    void onCreate(Bundle saveInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void onSaveInstanceState(Bundle outState);

    boolean onTouchEvent(MotionEvent event);

    void onBackPressed();

    void attach(Activity activity);
}
