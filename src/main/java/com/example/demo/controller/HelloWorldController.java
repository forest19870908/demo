package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Value("${com.neo.title}")
    private String title;
    @Value("${com.neo.description}")
    private String description;
    @RequestMapping("/hello")
    public String index(String t) {
        System.out.println(t);
        System.out.println(title);
        System.out.println(description);
        String encoding = System.getProperty("file.encoding");
        System.out.println("Default System Encoding:" + encoding);
        return title+description+"Hello World";
    }
    /*默认类中的方法都会以json的格式返回*/
    @RequestMapping("/getUser")
    public User getUser() {
        User user=new User();
        user.setName("张三");
        user.setPassword("XXX");
        return user;
    }
}
