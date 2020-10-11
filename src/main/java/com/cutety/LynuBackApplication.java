package com.cutety;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cutety.mapper")
@EnableAutoConfiguration(exclude={DruidDataSourceAutoConfigure.class})
public class LynuBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(LynuBackApplication.class, args);
    }

}
