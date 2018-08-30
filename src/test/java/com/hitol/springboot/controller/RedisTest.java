package com.hitol.springboot.controller;


import com.hitol.springboot.model.UserDO;
import com.hitol.springboot.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

public class RedisTest extends BaseTest {

    @Autowired
    private RedisTemplate<String, UserDO> redisTemplate;

    @Autowired
    private UserRepository userRepository;

   @Test
    public void redisReadTest(){

       getAllUserInfo();


       Set<String> keys = redisTemplate.keys("*");

       for (String key : keys) {
           logger.info("key = {},value = {}",key,getByKey(key).toString());
       }
   }

    private void getAllUserInfo() {
    }

    private UserDO getByKey(String key) {
       return redisTemplate.opsForValue().get(key);
    }

}
