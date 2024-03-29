package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.twoactivities.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void addItem(View view) {
        Intent intentItem=new Intent(this,MainActivity.class);
        String message=((Button)view).getText().toString();
        intentItem.putExtra(EXTRA_MESSAGE, message);
        setResult(RESULT_OK,intentItem);
        finish();
    }
}