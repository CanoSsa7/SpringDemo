package com.example.springdemo.Dao;

import com.example.springdemo.Entity.Student;
import com.example.springdemo.Entity.Teacher;
import com.example.springdemo.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StuMapper {
    @Select("select * from study.student")
    List<Student> getStudents();

    @Select("select * from study.teacher")
    List<Teacher> getTeachers();

    @Select("select * from study.web where username = #{username} and pwd = #{pwd}")
    User getUser(@Param("username") String username, @Param("pwd") String pwd);
}
