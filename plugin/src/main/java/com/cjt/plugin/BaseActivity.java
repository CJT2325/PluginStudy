package com.cjt.plugin;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.cjt.pluginlib.PluginInterface;

/**
 * =====================================
 * 作    者: 陈嘉桐
 * 版    本：1.1.4
 * 创建日期：2017/10/25
 * 描    述：
 * =====================================
 */
public class BaseActivity extends Activity implements PluginInterface {
    protected Activity that;

    @Override
    public void setContentView(int layoutResID) {
        if (that == null)
            super.setContentView(layoutResID);
        else
            that.setContentView(layoutResID);
    }

    @Override
    public View findViewById(int id) {
        if (that == null)
            return super.findViewById(id);
        else
            return that.findViewById(id);
    }

    @Override
    public ClassLoader getClassLoader() {
        if (that == null)
            return super.getClassLoader();
        else
            return that.getClassLoader();
    }

    @NonNull
    @Override
    public LayoutInflater getLayoutInflater() {
        if (that == null)
            return super.getLayoutInflater();
        else
            return that.getLayoutInflater();
    }


    @Override
    public WindowManager getWindowManager() {
        if (that == null)
            return super.getWindowManager();
        else
            return that.getWindowManager();
    }

    @Override
    public void onCreate(Bundle saveInstanceState) {
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void attach(Activity activity) {
        that = activity;
    }
}
