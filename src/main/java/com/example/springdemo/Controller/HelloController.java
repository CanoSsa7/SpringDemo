package com.example.springdemo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        String str = "Hello World!";
        System.out.println(str);
        return "<hr>";
    }
}
