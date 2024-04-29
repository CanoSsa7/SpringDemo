package com.example.springdemo.Controller;

import com.example.springdemo.Dao.StuMapper;
import com.example.springdemo.Utilis.MybatisUtil;
import com.example.springdemo.Entity.User;
import com.example.springdemo.Utilis.Result;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //包含@ResponseBody，会把返回的实体类和集合自动转换为json格式传给前端
public class ResponseController {
    @RequestMapping("/getStudents")
    Result getStudents(){
        SqlSession session = MybatisUtil.getSession(true);
        StuMapper mapper = session.getMapper(StuMapper.class);
        return Result.success(mapper.getStudents());
    }
}
