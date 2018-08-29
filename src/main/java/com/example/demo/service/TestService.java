package com.example.demo.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class TestService {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public void subNumber(Integer number){
        jdbcTemplate.update("update test set number=number-? where id=1",number);
        Integer result=jdbcTemplate.queryForObject("select number from test where id=1",Integer.class);
        if(result<0){
            throw new RuntimeException("库存不足，扣减失败");
        }
    }
}
