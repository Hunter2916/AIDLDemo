package com.hunter.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 创建服务
 */
public class AidlService extends Service {
    private static final String TAG = "ceshi";
    private AIDLBinder binder;
    Timer timer = new Timer();

    @Override
    public void onCreate() {
        Log.i(TAG, "AIDL_onCreate");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //随机地改变service组件内color、weight属性值
                if (binder != null) {
                    String text = binder.getText();
                    Log.i("ceshi", "文字：" + text);
                }
            }
        }, 1000, 1000);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "AIDL_onBind");
        binder = new AIDLBinder();
        return binder;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "AIDL_onDestroy");
        timer.cancel();
    }
}
