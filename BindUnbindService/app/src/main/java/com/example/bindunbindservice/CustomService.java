package com.example.bindunbindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by ied on 2017/10/8.
 */

public class CustomService extends Service {
    /**
     * 应用程序标记
     */
    private static final String TAG = "bind_unbind_service";

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "CustomService.onBind()");
        // 获取从前台窗口传递过来的数据
        String message = intent.getStringExtra("message");
        // 通过吐司在前台窗口显示获取数据
        Toast.makeText(getApplicationContext(), "恭喜，成功绑定服务！\n\n主窗口传递的数据："
                + message, Toast.LENGTH_SHORT).show();
        // 在调试窗口输出信息
        Log.i(TAG, "恭喜，成功绑定服务！\n\n主窗口传递的数据：" + message);
        // 返回绑定器对象
        return new Binder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "CustomService.onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "CustomService.onStartCommand()" + CustomService.this.hashCode() + ": " + startId);
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "CustomService.onDestroy()");
    }
}

