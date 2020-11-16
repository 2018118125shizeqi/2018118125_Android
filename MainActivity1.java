package com.example.lum.mydroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private  BroadCastReceive mBroadCastReceive ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();

        //创建广播接受类实例化对象
        mBroadCastReceive = new BroadCastReceive();
        IntentFilter intentFiltet = new IntentFilter();
        //设置广播的名字（设置Action，可以添加多个要监听的动作）
        intentFiltet.addAction("myBroadCastAction");
        //注册广播,传入两个参数， 实例化的广播接受者对象，intent 动作筛选对象
        registerReceiver(mBroadCastReceive,intentFiltet);


        //新建intent 对象
        Intent intent = new Intent();
        //设置 动作
        intent.setAction("myBroadCastAction");
        //添加传递的参数
        intent.putExtra("data", "Hi!I am broadcastData!");
        sendBroadcast(intent);

    }

    @Override
    protected void onPause() {
        //取消注册
        unregisterReceiver(mBroadCastReceive);
        super.onPause();
    }
}
