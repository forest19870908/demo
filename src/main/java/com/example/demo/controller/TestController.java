package com.example.demo.controller;

import com.example.demo.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class TestController {
    @Resource
    private TestService testService;

    @RequestMapping("/subNumber")
    public String subNumber(Integer number) {
//        for (int i = 0; i <5; i++) {
//            Thread t=new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("11111");
//                    testService.subNumber(number);
//                }
//            });
//            t.start();
//        }
        testService.subNumber(number);
       return "扣减成功";
    }
}
