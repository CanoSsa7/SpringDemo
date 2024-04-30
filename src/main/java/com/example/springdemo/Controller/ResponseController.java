package com.example.springdemo.Controller;

import com.example.springdemo.Service.StuService;
import com.example.springdemo.Utilis.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //包含@ResponseBody，会把返回的实体类和集合自动转换为json格式传给前端
public class ResponseController {

    @Autowired
    private StuService stuService;
    @RequestMapping("/getStudents")
    Result getStudents(){
        return Result.success(stuService.getStudents());
    }
    @RequestMapping("/getTeachers")
    Result getTeacher(){
        return Result.success(stuService.getTeachers());
    }
}
