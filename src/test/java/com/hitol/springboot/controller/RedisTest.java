package com.hitol.springboot.controller;


import com.hitol.springboot.model.UserDO;
import com.hitol.springboot.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class RedisTest extends BaseTest {

    @Autowired
    private RedisTemplate<String, UserDO> redisTemplate;

    @Autowired
    private  UserRepository userRepository;

    public  List<UserDO> getAllUserInfo() {

        return userRepository.findAll();
    }
    @Test
    public void redisReadTest() {

        List<UserDO> list = getAllUserInfo();

        if (CollectionUtils.isEmpty(list)){
            return ;
        }

        for (UserDO userDO : list) {
            Long id = userDO.getId();
            redisTemplate.opsForValue().set(id.toString(),userDO);
        }


        Set<String> keys = redisTemplate.keys("*");

        for (String key : keys) {
            logger.info("key = {},value = {}", key, getByKey(key).toString());
        }
    }


    private UserDO getByKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
