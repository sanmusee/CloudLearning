package com.cloud.test.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 主类同时充当Controller角色
@RestController
// 表明自己是一个eureka client
@EnableEurekaClient
@SpringBootApplication
public class EurekaclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaclientApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    // 直接在主类中写mapping方法，那么主类需要用@RestController进行注解
    // 也可以新加一个类，这个类就只需要@RestController这一个注解，主类只需要两个注解
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        System.out.println("hello, mapping");
        return "hi "+name+",i am from port:" +port;
    }

    // 浏览器通过访问 http://localhost:8762/hi?name=forezp 进行测试
}
