package com.example.springdemo.Dao;

import com.example.springdemo.Entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StuMapper {
    @Select("select * from study.student")
    List<Student> getStudents();
}
