package com.example.springdemo.Service.impl;

import com.example.springdemo.Dao.StuMapper;
import com.example.springdemo.Entity.Student;
import com.example.springdemo.Entity.Teacher;
import com.example.springdemo.Entity.User;
import com.example.springdemo.Service.StuService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    @Override
    public List<Student> getStudents() {
//        PageHelper.startPage(1, 1);
//        List<Student> studentList = stuMapper.getStudents();
//        PageInfo pageInfo = new PageInfo( studentList );
//        return pageInfo.getList();
        return stuMapper.getStudents();
    }

    @Override
    public List<Teacher> getTeachers() {
        return stuMapper.getTeachers();
    }

    @Override
    public User getUser(String username, String pwd) {
        return stuMapper.getUser(username, pwd);
    }
}
