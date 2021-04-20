package com.example.nsucpcstudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class StudentList extends AppCompatActivity {
    private StudentViewModel studentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        RecyclerView recyclerView=findViewById(R.id.recycler_item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        StudentListAdapter adapter = new StudentListAdapter();
        recyclerView.setAdapter(adapter);

        studentViewModel= (new ViewModelProvider(this
                ,ViewModelProvider.AndroidViewModelFactory.getInstance
                (this.getApplication()))).get(StudentViewModel.class);
//        studentViewModel= new ViewModelProvider(this).get(StudentViewModel.class);
        studentViewModel.getAllStudents().observe(this, new Observer<List<StudentData>>() {
            @Override
            public void onChanged(List<StudentData> studentData) {
                adapter.setStudentList(studentData);
                adapter.notifyDataSetChanged();
//                Toast.makeText(StudentList.this,"Changes",Toast.LENGTH_SHORT).show();
            }
        });
    }
}