package com.example.springdemo.Config;

import com.alibaba.fastjson.JSON;
import com.example.springdemo.Service.StuService;
import org.apache.commons.logging.Log;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class BeanHandler {
    /**
     * 注入第三方bean进行管理
     * @param stuService 方法参数中的对象会自动注入
     * @return 加入bean管理对象的实例
     */
    @Bean
//    @ConditionalOnClass(name = "com.xxx") //当前环境存在指定类，才声明该bean
//    @ConditionalOnMissingBean(name = "com.xxx", value = xxx.class) //当前容器不存在指定类类型，才声明该bean
//    @ConditionalOnProperty(name = "", havingValue = "") //配置文件存在指定值，才声明该bean
    Logger getLogger(StuService stuService){
        System.out.println(stuService); //自动注入方法参数中的对象
        return Logger.getLogger("myLogger");
    }
}
