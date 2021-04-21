package com.example.nsucpcstudent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentListHolder> {
    private List<StudentData> students=new ArrayList<>();
    @NonNull
    @Override
    public StudentListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item,parent,false);
        return new StudentListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentListHolder holder, int position) {
        StudentData currentStudent = students.get(position);
        holder.textViewId.setText(String.valueOf(currentStudent.getNsuId()));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public void setStudentList(List<StudentData> students){
        this.students=students;
        notifyDataSetChanged();
    }

    class StudentListHolder extends RecyclerView.ViewHolder {
        private TextView textViewId;

        public StudentListHolder(@NonNull View itemView) {
            super(itemView);
            textViewId= itemView.findViewById(R.id.student_list_id);
        }
    }
}
