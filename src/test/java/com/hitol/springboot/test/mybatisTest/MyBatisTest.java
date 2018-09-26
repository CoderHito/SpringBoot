package com.hitol.springboot.test.mybatisTest;

import com.hitol.springboot.mapper.UserMapper;
import com.hitol.springboot.model.User;
import com.hitol.springboot.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBatisTest extends BaseTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void findByNameTest(){
        User user = mapper.findByName("lll");
        getLogger().info(user.toString());
    }

    @Test
    public void insertTest(){
//        mapper.insertUser("kkk",999);
        User user = new User();
        user.setId(987L);
        user.setName("lll");
        mapper.insertUser(user);

        User user2 = mapper.findByName("lll");
        getLogger().info(user2.toString());
    }
}
