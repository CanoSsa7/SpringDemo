package com.example.springdemo.Service;

import com.example.springdemo.Entity.Student;
import com.example.springdemo.Entity.Teacher;

import java.util.List;

public interface StuService {
    List<Student> getStudents();
    List<Teacher> getTeachers();
}
