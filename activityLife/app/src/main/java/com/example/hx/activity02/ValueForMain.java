package com.example.hx.activity02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by hx on 2018/4/4.
 */

public class ValueForMain extends AppCompatActivity {
    private static String TAG = "LIFTCYCLE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Log.i(TAG, "SecondActivity(1) onCreate()");

        Button button3=(Button)findViewById(R.id.btn3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(ValueForMain.this,MainActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override  //可视生命周期开始时被调用，对用户界面进行必要的更改
    public void onStart() {
        super.onStart();
        Log.i(TAG, "SecondActivity(2) onStart()");
    }

    @Override  //在onStart()后被调用，用于恢复onSaveInstanceState()保存的用户界面信息
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "SecondActivity(3) onRestoreInstanceState()");
    }

    @Override  //在活动生命周期开始时被调用，恢复被onPause()停止的用于界面更新的资源
    public void onResume() {
        super.onResume();
        Log.i(TAG, "SecondActivity(4) onResume()");
    }

    @Override  // 在onResume()后被调用，保存界面信息
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "SecondActivity(5) onSaveInstanceState()");
    }

    @Override  //在重新进入可视生命周期前被调用，载入界面所需要的更改信息
    public void onRestart() {
        super.onRestart();
        Log.i(TAG, "SecondActivity(6) onRestart()");
    }

    @Override  //在活动生命周期结束时被调用，用来保存持久的数据或释放占用的资源
    public void onPause() {
        super.onPause();
        Log.i(TAG, "SecondActivity(7) onPause()");
    }

    @Override //在可视生命周期结束时被调用，一般用来保存持久的数据或释放占用的资源
    public void onStop() {
        super.onStop();
        Log.i(TAG, "SecondActivity(8) onStop()");
    }

    @Override //在完全生命周期结束时被调用，释放资源，包括线程、数据连接等
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "SecondActivity(9) onDestroy()");
    }
}
