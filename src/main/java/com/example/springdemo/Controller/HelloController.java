package com.example.springdemo.Controller;

import com.example.springdemo.Entity.User;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class HelloController {
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime updateTime){
        System.out.println(updateTime);
        return updateTime.toString();
    }
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        System.out.println(user);
        return "get json";
    }
    @RequestMapping("/hello")
    public String hello(){
        String str = "Hello World!";
        System.out.println(str);
        return "<hr>" + str;
    }

    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name = "name")String username, String age){
        System.out.println(username + ": " + age);
        return "okkkkk";
    }

    @RequestMapping("/simpleEntity")
    public String entityDemo(User user){
        System.out.println(user);
        return "get user";
    }
    @RequestMapping("/arrayParam")
    public String arrayParam(@RequestParam List<String> name){
        name.forEach(System.out::println);
        return "ok";
    }
}
