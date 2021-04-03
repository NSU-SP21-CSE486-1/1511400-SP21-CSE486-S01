package com.example.nsucpcstudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

//import java.security.acl.Group;

public class RegistrationSecondStep extends AppCompatActivity {
    private TextView title;
    private SwitchMaterial addressSwitch;
    private Group addressGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_second_step);
        addressSwitch= findViewById(R.id.same_address);
        addressGroup=findViewById(R.id.group);
        title=findViewById(R.id.permanent_address_title);
        addressSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    addressGroup.setVisibility(View.GONE);
                }else {
                    addressGroup.setVisibility(View.VISIBLE);
                }
            }
        });
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