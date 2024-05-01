package com.example.springdemo.Controller;

import com.aliyuncs.exceptions.ClientException;
import com.example.springdemo.Utilis.AliOSSUtils;
import com.example.springdemo.Utilis.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileController {
    @Autowired
    AliOSSUtils aliOss;
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException, ClientException {
        String url = aliOss.upload(image);
        return Result.success(url);
    }
}
