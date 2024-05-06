package com.example.springdemo.Filter;


import com.example.springdemo.Utilis.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.http.HttpResponse;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*") 被注释掉了, filter不会工作
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截请求");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpResponse resp = (HttpResponse) servletResponse;

        String url = req.getRequestURL().toString();
        System.out.println("URL:" + url);
        if(url.endsWith("login")){ //登录操作不过滤
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        String jwt = req.getHeader("jwt");
        Claims claims = JwtUtils.parseJWT(jwt);


        filterChain.doFilter(servletRequest, servletResponse);
    }

}
