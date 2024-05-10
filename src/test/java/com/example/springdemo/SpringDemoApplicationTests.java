package com.example.springdemo;

import com.example.springdemo.Controller.ResponseController;
import com.example.springdemo.Service.StuService;
import com.example.springdemo.Service.impl.StuServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootTest
class SpringDemoApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Autowired
    Logger logger; //自定义第三方bean注入
    @Test
    void testLoggerBean(){
        logger.log(Level.WARNING, "hihihihi");
    }
    @Test
    void testBean(){
        ResponseController responseController = (ResponseController) context.getBean(ResponseController.class);
        System.out.println(responseController);
    }
    @Test
    void contextLoads() {
    }
    @Test
    public void testGenerateJWT(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("name", "admin");
        claims.put("id", "123456");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "CanoSsa7")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 3600))
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJWT(){
        Claims claim = Jwts.parser()
                .setSigningKey("CanoSsa7")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiWmhoIiwiaWQiOiIxMTExIiwiZXhwIjoxNzE0ODI4MDMzfQ.qZQ4O8Z-I4nH1WGtD-aoegQaC8HW2ff3I7AHCodPQ8c")
                .getBody();
        System.out.println(claim);
    }

}
