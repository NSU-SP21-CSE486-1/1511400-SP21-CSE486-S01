package com.example.nsucpcstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SuccessScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_screen);
    }

    public void goToHomeScreen(View view) {
        Intent homeIntent = new Intent(this, MainActivity.class);
        startActivity(homeIntent);
    }
}