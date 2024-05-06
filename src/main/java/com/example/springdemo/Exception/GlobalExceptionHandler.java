package com.example.springdemo.Exception;

import com.example.springdemo.Utilis.Result;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handler(Exception e){
        e.printStackTrace();
        return Result.fail("Wrong Server Response");
    }
//    @ModelAttribute
//    void func(Model model){
//        model.addAttribute()
//    }
}
