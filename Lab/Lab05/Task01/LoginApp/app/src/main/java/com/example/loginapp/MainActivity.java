package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.loginapp.extra.MESSAGE";
    private String demo_email="rana.masud@northsouth.edu";
    private String demo_pass="demo1234";
    private EditText mEmail;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmail = findViewById(R.id.editTextTextEmailAddress);
        mPassword = findViewById(R.id.editTextTextPassword);
    }

    public void logIn(View view) {
        String finalEmail = mEmail.getText().toString();
        String finalPass = mPassword.getText().toString();

        if(demo_email.equals(finalEmail) && demo_pass.equals(finalPass)){
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(EXTRA_MESSAGE, finalEmail);
            startActivity(intent);
            finish();
        }


        else{
            Toast toast = Toast.makeText(this, R.string.toast_error,
                    Toast.LENGTH_SHORT);
            toast.show();

        }
    }
}