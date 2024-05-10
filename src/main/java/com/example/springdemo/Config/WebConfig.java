package com.example.springdemo.Config;

import com.example.springdemo.Filter.LoginCheckFilter;
import com.example.springdemo.Interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //注明是配置类
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    LoginInterceptor interceptor;
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器并指定拦截所有资源的请求
//        registry.addInterceptor(interceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login"); // "/**"代表拦截任意级路径
    }
}
