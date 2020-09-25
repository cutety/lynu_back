package com.cutety;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cutety.mapper")
public class LynuBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LynuBackApplication.class, args);
    }

}
