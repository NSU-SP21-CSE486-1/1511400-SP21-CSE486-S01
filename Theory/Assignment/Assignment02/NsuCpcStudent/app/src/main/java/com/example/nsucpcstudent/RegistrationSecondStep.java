package com.example.nsucpcstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegistrationSecondStep extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_second_step);
    }

    public void launchThirdStepScreen(View view) {
        Intent successIntent = new Intent(this, SuccessScreen.class);
        startActivity(successIntent);
    }

    public void goFirstStepScreen(View view) {
        Intent firstIntentScreen = new Intent(this, RegistrationFirstStep.class);
        startActivity(firstIntentScreen);
    }
}