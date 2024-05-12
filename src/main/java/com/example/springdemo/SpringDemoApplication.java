package com.example.springdemo;

import com.github.pagehelper.PageHelper;
import jdk.dynalink.linker.support.SimpleLinkRequest;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Properties;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)


/**
 * 关于@SpringBootApplication的自动装配
 * 包含了@EnableAutoConfiguration, import了@Import({AutoConfigurationImportSelector.class})
 * 在AutoConfigurationImportSelector类中的String[] selectImports方法返回了需要装配的类名
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.example.springdemo.Dao") //自动扫描mapper，装填进IOC容器
public class SpringDemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Configuration
    public class MybatisConfig {
        @Bean
        public PageHelper pageHelper() {
            System.out.println("MyBatisConfiguration.pageHelper()");
            PageHelper pageHelper = new PageHelper();
            Properties p = new Properties();

            p.setProperty("offsetAsPageNum", "true");
            p.setProperty("rowBoundsWithCount", "true");
            p.setProperty("reasonable", "true");
            pageHelper.setProperties(p);
            return pageHelper;
        }
    }
}
