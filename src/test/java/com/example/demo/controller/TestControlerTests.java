package com.example.demo.controller;

import com.example.demo.service.TestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestControlerTests {
    private MockMvc mvc;
    @Resource
    private TestController testController;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(testController).build();
    }
    @Test
    @Rollback(false)
    public void subNumber() throws Exception {
//        ExecutorService executorService = Executors.newFixedThreadPool(30);
//        for (int i = 0; i < 3; i++) {
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Integer number=5;//new Random(10).nextInt();
//                        mvc.perform(MockMvcRequestBuilders.get("/subNumber").param("number",number.toString()).accept(MediaType.APPLICATION_JSON))
//                                .andExpect(MockMvcResultMatchers.status().isOk())
//                                .andDo(MockMvcResultHandlers.print())
//                                .andReturn();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
        Integer number=5;//new Random(10).nextInt();
        mvc.perform(MockMvcRequestBuilders.get("/subNumber").param("number",number.toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();


    }
}