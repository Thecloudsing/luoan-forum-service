package com.luoanforum.oauth;

import com.luoanforum.oauth.controller.MainController;
import lombok.val;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableFeignClients
@MapperScan("com.luoanforum.oauth.domain.mapper")
public class OAuthApplication
{

    public static void main( String[] args ) throws InterruptedException {
        val run = SpringApplication.run(OAuthApplication.class, args);
//        while (true) {
//            val luoanforum = run.getEnvironment().getProperty("luoanforum");
//            val property = run.getEnvironment().getProperty("bootstrap-oauth");
//            val oauth = run.getEnvironment().getProperty("oauth");
//            System.out.printf("luoanforum is %s \n", luoanforum);
//            System.out.printf("property is %s \n", property);
//            System.out.printf("oauth is %s \n", oauth);
//            TimeUnit.SECONDS.sleep(2);
//        }
    }
}
