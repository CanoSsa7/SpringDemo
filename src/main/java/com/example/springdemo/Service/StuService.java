package com.example.springdemo.Service;

import com.example.springdemo.Entity.Student;
import com.example.springdemo.Entity.Teacher;
import com.example.springdemo.Entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface StuService {
    List<Student> getStudents();
    List<Teacher> getTeachers();
    User getUser(String username, String pwd);
    void addStudent(Student student);
}
