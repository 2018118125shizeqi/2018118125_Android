package com.example.lum.mydroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by lum on 2018/5/27.
 */

public class BroadCastReceive extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("myBroadCast")) {
            //接收到广播，取出里面携带的数据
            String str = intent.getStringExtra("data");
            System.out.println("接收到的广播的数据：" + str);
        }
    }
}
