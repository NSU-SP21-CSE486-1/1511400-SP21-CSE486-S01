package com.example.nsucpcstudent;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {
    private StudentsRepository repository;
    private LiveData<List<StudentData>> allStudents;

    public StudentViewModel(@NonNull Application application){
        super(application);
        repository=new StudentsRepository(application);
        allStudents= repository.getAllStudents();
    }

    public void insert(StudentData studentData){
        repository.insert(studentData);
    }

    public void update(StudentData studentData){
        repository.update(studentData);
    }

    public void delete(StudentData studentData){
        repository.delete(studentData);
    }

    public LiveData<List<StudentData>> getAllStudents(){
        return allStudents;
    }


}
