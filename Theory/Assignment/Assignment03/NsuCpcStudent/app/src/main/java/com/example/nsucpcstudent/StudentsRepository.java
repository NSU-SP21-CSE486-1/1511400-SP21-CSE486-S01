package com.example.nsucpcstudent;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentsRepository {
    private StudentDao studentDao;
    private LiveData<List<StudentData>> allStudents;

    public StudentsRepository(Application application){
        StudentDatabase database = StudentDatabase.getInstance(application);
        studentDao=database.studentDao();
        allStudents=studentDao.getAllStudents();
    }

    public  void insert(StudentData studentData){
        new InsertStudent(studentDao).execute(studentData);
    }

    public  void update(StudentData studentData){
        new UpdateStudent(studentDao).execute(studentData);

    }

    public  void delete(StudentData studentData){
        new DeleteStudent(studentDao).execute(studentData);
    }

    public LiveData<List<StudentData>> getAllStudents(){
        return  allStudents;
    }

    private static class InsertStudent extends AsyncTask<StudentData,Void,Void>{
        private  StudentDao studentDao;

        private InsertStudent(StudentDao studentDao){
            this.studentDao=studentDao;
        }
        @Override
        protected Void doInBackground(StudentData... studentData) {
            studentDao.insert(studentData[0]);
            return null;
        }
    }

    private static class DeleteStudent extends AsyncTask<StudentData,Void,Void>{
        private  StudentDao studentDao;

        private DeleteStudent(StudentDao studentDao){
            this.studentDao=studentDao;
        }
        @Override
        protected Void doInBackground(StudentData... studentData) {
            studentDao.delete(studentData[0]);
            return null;
        }
    }

    private static class UpdateStudent extends AsyncTask<StudentData,Void,Void>{
        private  StudentDao studentDao;

        private UpdateStudent(StudentDao studentDao){
            this.studentDao=studentDao;
        }
        @Override
        protected Void doInBackground(StudentData... studentData) {
            studentDao.update(studentData[0]);
            return null;
        }
    }

}
