package com.example.springdemo.Interceptor;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.common.utils.StringUtils;
import com.example.springdemo.Utilis.JwtUtils;
import com.example.springdemo.Utilis.Result;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        System.out.println("控制器运行前");

        String url = req.getRequestURL().toString();
        System.out.println("URL:" + url);
        if(url.endsWith("login")){ //登录操作不过滤
            return true;
        }
        String jwt = req.getHeader("jwt"); //从请求头中获取JWT

        if(StringUtils.isNullOrEmpty(jwt)){ //请求携带的JWT为空，未登录
            System.out.println("令牌信息为空");
            String Json = JSON.toJSONString(Result.fail("NULL JWT"));
            resp.getWriter().write(Json);
            return false;
        }
        try {
            JwtUtils.parseJWT(jwt);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("令牌信息有误");
            String Json = JSON.toJSONString(Result.fail("WRONG JWT"));
            resp.getWriter().write(Json);
            return false;
        }
        //令牌解析成功
        System.out.println("令牌解析成功");
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("控制器运行后");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");

    }
}
