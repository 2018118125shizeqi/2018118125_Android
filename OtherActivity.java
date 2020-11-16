package com.example.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends Activity {
    private TextView myTextView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
        myTextView = (TextView)findViewById(R.id.myText);
        myTextView.setText(R.string.other);
    }
}
