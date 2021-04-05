package com.example.nsucpcstudent;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName = "student_table")
public class StudentData {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String fullName;
    private int nsuId;
    private String school;
    private String department;
    private Date birthDate;
    private String phoneNumber;
    private int nationalId;
    @Embedded public Address presentAddress;
    @Embedded public Address permanentAddress;

    public StudentData(String fullName, int nsuId, String school, String department, Date birthDate, String phoneNumber, int nationalId, Address presentAddress, Address permanentAddress) {
        this.fullName = fullName;
        this.nsuId = nsuId;
        this.school = school;
        this.department = department;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.nationalId = nationalId;
        this.presentAddress = presentAddress;
        this.permanentAddress = permanentAddress;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getNsuId() {
        return nsuId;
    }

    public String getSchool() {
        return school;
    }

    public String getDepartment() {
        return department;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getNationalId() {
        return nationalId;
    }

    public Address getPresentAddress() {
        return presentAddress;
    }

    public Address getPermanentAddress() {
        return permanentAddress;
    }
}
