package com.example.nsucpcstudent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

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

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class RegistrationFirstStep extends AppCompatActivity {
    private String fullName;
    private int nsuId;
    private String nsuEmail;
    private String school;
    private String department;
    private String birthDate;
    private String phoneNumber;
    private int nationalId;

    private String[] schoolList;
    private String[] ScienceSchoolList;
    private String[] BusinessSchoolList;
    private String[] HumanSchoolList;
    private String[] HealthSchoolList;
    private AutoCompleteTextView schoolDropdown;
    private AutoCompleteTextView departmentDropdown;

    private TextInputLayout valueFullName;
    private TextInputLayout valueNsuId;
    private TextInputLayout valueDate;
    private TextInputEditText birthDateText;
    private TextInputLayout valueNsuEmail;
    private TextInputLayout valueNid;
    private TextInputLayout valueSchool;
    private TextInputLayout valueDepartment;
    private TextInputLayout valueMobile;

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

        valueFullName=(TextInputLayout)findViewById(R.id.full_name);
        valueNsuId=(TextInputLayout)findViewById(R.id.nsu_id);
        valueDate=(TextInputLayout)findViewById(R.id.birth_date);
        birthDateText=(TextInputEditText)findViewById(R.id.birth_date_text);
        valueNsuEmail=(TextInputLayout)findViewById(R.id.nsu_email);
        valueNid=(TextInputLayout)findViewById(R.id.nid);
        valueSchool=(TextInputLayout)findViewById(R.id.school);
        valueDepartment=(TextInputLayout)findViewById(R.id.department);
        valueMobile=(TextInputLayout)findViewById(R.id.mobile);

        schoolDropdown = (AutoCompleteTextView) findViewById(R.id.select_school);
        departmentDropdown = (AutoCompleteTextView) findViewById(R.id.select_department);

        ArrayAdapter<String> schoolAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.item_list,schoolList);
        schoolDropdown.setAdapter(schoolAdapter);

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

        birthDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(),"datePicker");
            }
        });

//        if(savedInstanceState != null){
//            valueFullName.getEditText().setText(savedInstanceState.getString("fullName"));
//            valueNsuId.getEditText().setText(savedInstanceState.getInt("nsuId"));
//            birthDateText.setText(savedInstanceState.getString("birthDate"));
//            valueNsuEmail.getEditText().setText(savedInstanceState.getString("nsuEmail"));
//            valueNid.getEditText().setText(savedInstanceState.getInt("nid"));
//            valueSchool.getEditText().setText(savedInstanceState.getString("school"));
//            valueDepartment.getEditText().setText(savedInstanceState.getString("department"));
//            valueMobile.getEditText().setText(savedInstanceState.getString("mobile"));
//        }
    }



    public void setDepartment (String s){
        if(s.equals(schoolList[0]) ){
            departmentDropdown.getText().clear();
            departmentAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.item_list,BusinessSchoolList);
            departmentDropdown.setAdapter(departmentAdapter);
        }
        else if(s.equals(schoolList[1]) ){
            departmentDropdown.getText().clear();
            departmentAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.item_list,ScienceSchoolList);
            departmentDropdown.setAdapter(departmentAdapter);
        }
        else if(s.equals(schoolList[2]) ){
            departmentDropdown.getText().clear();
            departmentAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.item_list,HumanSchoolList);
            departmentDropdown.setAdapter(departmentAdapter);
        }
        else if(s.equals(schoolList[3]) ){
            departmentDropdown.getText().clear();
            departmentAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.item_list,HealthSchoolList);
            departmentDropdown.setAdapter(departmentAdapter);
        }

    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }
    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string + "/" + day_string + "/" + year_string);
        birthDateText.setText(dateMessage);
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState){
//        super.onSaveInstanceState(outState);
//
//        fullName=valueFullName.getEditText().getText().toString();
//        nsuId=Integer.parseInt(valueNsuId.getEditText().getText().toString());
//        birthDate=birthDateText.getText().toString();
//        nsuEmail=valueNsuEmail.getEditText().getText().toString();
//        nationalId= Integer.parseInt(valueNid.getEditText().getText().toString());
//        school=valueSchool.getEditText().getText().toString();
//        department=valueDepartment.getEditText().getText().toString();
//        phoneNumber=valueMobile.getEditText().getText().toString();

//        outState.putString("fullName",fullName);
//        outState.putInt("nsuId", nsuId);
//        outState.putString("birthDate",birthDate);
//        outState.putString("nsuEmail",nsuEmail);
//        outState.putInt("nid",nationalId);
//        outState.putString("school",school);
//        outState.putString("department",department);
//        outState.putString("mobile",phoneNumber);
//    }

    public void launchSecondStepScreen (View view ){


        Intent secondIntent = new Intent(this, RegistrationSecondStep.class);
        startActivity(secondIntent);


//        Toast toast = Toast.makeText(this, text,
//                Toast.LENGTH_SHORT);
//        toast.show();
    }
}
