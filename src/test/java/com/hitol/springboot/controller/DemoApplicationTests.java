package com.hitol.springboot.controller;

import com.hitol.springboot.model.UserDO;
import com.hitol.springboot.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUser() {
        UserDO userDO = new UserDO();
        userDO.setId(10L);
        userDO.setName("赵四");
        UserDO userDO1 = userRepository.save(userDO);
        userDO1.setName("尼古拉斯赵四");
    }

    @Test
    public void saveUserList(){
        List<UserDO> list = new ArrayList<>();

        long count = userRepository.count();

        for (int i = (int)count; i < count + 10; i++) {
            UserDO userDO = new UserDO();
            userDO.setId(Long.valueOf(i));
            userDO.setName("zhaosi" + i);
            list.add(userDO);
        }
        List<UserDO> result = userRepository.saveAll(list);
        for (UserDO userDO : result) {
            System.out.println(userDO.toString());
        }
    }



    @Test
    @Transactional
    public void getOne(){
        UserDO userDO = userRepository.getOne(10L);
        System.out.println(userDO.toString());
        userDO.setName("尼古拉斯赵四");
    }

    @Test
    @Transactional
    public void findOne(){
        /**
         * findOne 接口是1.xx版本中的方法
         * 2.xx版本中使用  Optional<T> findById(ID var1);
         *
         */
        Optional<UserDO> optional =  userRepository.findById(10L);

        UserDO userDO = optional.get();
        System.out.println(optional);
        userDO.setName("尼古拉斯赵四");

    }



    @Test
    public void findAll(){
//        UserDO userDO = userRepository.findOne(10L);
        List<UserDO> list =  userRepository.findAll();
        for (UserDO userDO : list) {
            System.out.println(userDO.toString());
        }
    }






}
