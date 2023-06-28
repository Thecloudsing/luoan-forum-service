package com.example.luoanforumservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan({"com.example.luoanforumservice.module.user.mapper", "com.example.luoanforumservice.module.chat.mapper", "com.example.luoanforumservice.module.dynamic.mapper"})
@ServletComponentScan
public class LuoanForumServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuoanForumServiceApplication.class, args);
    }

}
