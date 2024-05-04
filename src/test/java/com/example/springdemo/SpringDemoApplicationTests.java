package com.example.springdemo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class SpringDemoApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void testGenerateJWT(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("name", "Zhh");
        claims.put("id", "1111");
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
