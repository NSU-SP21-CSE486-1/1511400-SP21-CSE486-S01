package com.example.nsucpcstudent;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insert(StudentData studentData);

    @Update
    void update(StudentData studentData);

    @Delete
    void delete(StudentData studentData);

    @Query("SELECT * FROM student_table ORDER BY nsuId ASC")
    LiveData<List<StudentData>> getAllStudents();
}
