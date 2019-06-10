package com.lindj.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lindj
 * @date 2019/3/21
 * @description
 */
@SpringBootApplication
@MapperScan("com.lindj.boot.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
