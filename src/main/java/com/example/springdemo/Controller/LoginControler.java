package com.example.springdemo.Controller;

import com.example.springdemo.Entity.User;
import com.example.springdemo.Service.StuService;
import com.example.springdemo.Utilis.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginControler {
    @Autowired
    private StuService stuService;
    @PostMapping("/login")
    Result login(@RequestBody User user){
        User u = stuService.getUser(user.getUsername(), user.getPwd());
        if(u == null){
            System.out.println("登录失败");
            return Result.fail("未找到用户");
        }else{
            System.out.println(u.getUsername()+ "登陆成功");
            return Result.success();
        }
    }
}
