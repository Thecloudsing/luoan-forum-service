package com.luoanforum.message;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.luoanforum.message.domain.mapper")
public class MessageApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(MessageApplication.class, args);
    }
}
