package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelloWorldActivity extends Activity {
    /** Called when the activity is first created. */
    private Button myButton = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        myButton = (Button) findViewById(R.id.myButton);
        myButton.setText("请按我！");
        myButton.setOnClickListener(new MyButtonListenter());
    }

    class MyButtonListenter implements OnClickListener {

        public void onClick(View v) {
            // 生成一个Intent对象
            Intent intent = new Intent();
            intent.setClass(HelloWorldActivity.this, OtherActivity.class);
            HelloWorldActivity.this.startActivity(intent);
        }
    }
}
