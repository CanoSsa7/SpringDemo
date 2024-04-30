package com.example.springdemo.Service.impl;

import com.example.springdemo.Dao.StuMapper;
import com.example.springdemo.Entity.Student;
import com.example.springdemo.Entity.Teacher;
import com.example.springdemo.Service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    @Override
    public List<Student> getStudents() {
        return stuMapper.getStudents();
    }

    @Override
    public List<Teacher> getTeachers() {

        return stuMapper.getTeachers();
    }
}
