package com.example.lum.mydroadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        //设置广播的名字（设置Action）
        intent.setAction("myBroadCast");
        //携带数据
        intent.putExtra("data","hello");
        //发送广播（无序广播）
        sendBroadcast(intent);
    }
}