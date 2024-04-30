package com.example.springdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication

@MapperScan("com.example.springdemo.Dao")
public class SpringDemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

}
