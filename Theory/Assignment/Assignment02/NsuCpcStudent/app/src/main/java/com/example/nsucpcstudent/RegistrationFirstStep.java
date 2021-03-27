package com.example.nsucpcstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegistrationFirstStep extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_first_step);
    }

    public void launchSecondStepScreen(View view) {
        Intent secondIntent = new Intent(this, RegistrationSecondStep.class);
        startActivity(secondIntent);
    }
}