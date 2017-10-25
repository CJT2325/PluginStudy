package com.cjt.host;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import com.cjt.pluginlib.PluginInterface;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * =====================================
 * 作    者: 陈嘉桐
 * 版    本：1.1.4
 * 创建日期：2017/10/25
 * 描    述：
 * =====================================
 */
public class ProxyActivity extends Activity {
    private String className;
    PluginInterface pluginInterface;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        className = getIntent().getStringExtra("className");

        Log.i("CJT", "className = " + className);
        try {
            if (getClassLoader() == null) {
                Log.i("CJT", "is Null");
            } else {
                Class activityClass = getClassLoader().loadClass(className);
                Constructor constructor = activityClass.getConstructor(new Class[]{});
                Object instance = constructor.newInstance(new Object[]{});
                pluginInterface = (PluginInterface) instance;
                pluginInterface.attach(this);
                Bundle bundle = new Bundle();
                pluginInterface.onCreate(bundle);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ClassLoader getClassLoader() {
        return PluginManager.getInstance().getDexClassLoader();
    }

    @Override
    public Resources getResources() {
        return PluginManager.getInstance().getResources();
    }


    @Override
    protected void onStart() {
        super.onStart();
        pluginInterface.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        pluginInterface.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        pluginInterface.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        pluginInterface.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pluginInterface.onDestroy();
    }

}
