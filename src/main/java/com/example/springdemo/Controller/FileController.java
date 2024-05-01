package com.example.springdemo.Controller;

import com.example.springdemo.Utilis.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController

public class FileController {
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        String filename = image.getOriginalFilename();
        image.transferTo(new File("D:\\Code\\SpringDemo\\src\\main\\resources\\imgs\\" + filename));

        return Result.success();
    }
}
