package com.hunter.clientapp;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hunter.aidldemo.ICat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView btStart;
    private TextView btEnd;
    private TextView btContent;
    private Intent intent;
    private ICat iCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent();
        intent.setPackage("com.hunter.aidldemo");
        intent.setAction("com.hunter.aidldemo.AidlService");
        initView();

    }

    private void initView() {
        btStart = findViewById(R.id.bt_start);
        btEnd = findViewById(R.id.bt_end);
        btContent = findViewById(R.id.bt_content);

        btStart.setOnClickListener(this);
        btEnd.setOnClickListener(this);
        btContent.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:
                bindService(intent, connection, Service.BIND_AUTO_CREATE);
                Log.i("ceshi", "启动服务");
                break;
            case R.id.bt_end:
                unbindService(connection);
                Log.i("ceshi", "停止服务");
                break;
            case R.id.bt_content:
                try {
                    if (iCat != null) {
                        iCat.setText("我爱你");
                        Log.i("ceshi", "发送我爱你");
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("ceshi", "connection 已启动");
            iCat = ICat.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}