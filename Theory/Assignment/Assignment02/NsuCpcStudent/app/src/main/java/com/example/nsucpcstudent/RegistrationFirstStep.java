package com.example.nsucpcstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.TextureView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class RegistrationFirstStep extends AppCompatActivity {
    private String[] schoolList;
    private String[] ScienceSchoolList;
    private String[] BusinessSchoolList;
    private String[] HumanSchoolList;
    private String[] HealthSchoolList;

    private AutoCompleteTextView schoolDropdown;
    private AutoCompleteTextView departmentDropdown;
    private TextInputLayout valueSchool;
    private TextInputLayout valueDepartment;
    private String text;

    private ArrayAdapter<String> departmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_first_step);

        schoolList= getResources().getStringArray(R.array.schools_list);
        ScienceSchoolList= getResources().getStringArray(R.array.science_school_list);
        BusinessSchoolList= getResources().getStringArray(R.array.business_school_list);
        HumanSchoolList= getResources().getStringArray(R.array.human_school_list);
        HealthSchoolList= getResources().getStringArray(R.array.health_school_list);

        valueSchool=(TextInputLayout)findViewById(R.id.school);
        valueDepartment=(TextInputLayout)findViewById(R.id.department);

        schoolDropdown = (AutoCompleteTextView) findViewById(R.id.select_school);
        departmentDropdown = (AutoCompleteTextView) findViewById(R.id.select_department);

        ArrayAdapter<String> schoolAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.item_list,schoolList);
        schoolDropdown.setAdapter(schoolAdapter);

//        departmentAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.item_list,departmentList);
//        departmentDropdown.setAdapter(departmentAdapter);

        schoolDropdown.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               setDepartment(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


        public void launchSecondStepScreen (View view){
//            Intent secondIntent = new Intent(this, RegistrationSecondStep.class);
//            startActivity(secondIntent);
            text = valueSchool.getEditText().getText().toString();
//            Toast toast = Toast.makeText(this, text,
//                    Toast.LENGTH_SHORT);
//            toast.show();
        }
    public void setDepartment (String s){
        if(s.equals(schoolList[0]) ){
            departmentAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.item_list,ScienceSchoolList);
            departmentDropdown.setAdapter(departmentAdapter);
        }

    }
    }
