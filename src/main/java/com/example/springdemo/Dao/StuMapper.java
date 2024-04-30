package com.example.springdemo.Dao;

import com.example.springdemo.Entity.Student;
import com.example.springdemo.Entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StuMapper {
    @Select("select * from study.student")
    List<Student> getStudents();

    @Select("select * from study.teacher")
    List<Teacher> getTeachers();
}
