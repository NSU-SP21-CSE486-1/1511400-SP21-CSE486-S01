package com.example.nsucpcstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchRegScreen(View view) {
        Intent regIntent = new Intent(this, RegistrationFirstStep.class);
        startActivity(regIntent);
    }

    public void launchListScreen(View view) {
        Intent listIntent = new Intent(this, StudentList.class);
        startActivity(listIntent);
    }

    public void launchSearchScreen(View view) {
        Intent searchIntent = new Intent(this, SearchFilter.class);
        startActivity(searchIntent);
    }
}