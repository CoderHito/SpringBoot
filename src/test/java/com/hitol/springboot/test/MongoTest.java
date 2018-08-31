package com.hitol.springboot.test;

import com.hitol.springboot.model.UserDO;
import com.hitol.springboot.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public class MongoTest extends BaseTest {

    @Autowired
    private MongoRepository mongoRepository;
    @Autowired
    private  UserRepository userRepository;

    public  List<UserDO> getAllUserInfo() {

        return userRepository.findAll();
    }

    @Test
    public void saveMongoInfo() {

        List<UserDO> userDOList = getAllUserInfo();

        for (UserDO userDO : userDOList) {
            mongoRepository.save(userDO);
            getLogger().info(userDO.toString() + "保存成功");
        }

    }

    @Test
    public void readFromMongoTest() {
        List<UserDO> list = mongoRepository.findAll();
        for (UserDO userDO : list) {
            getLogger().info("读取___" + userDO.toString());
        }
    }

}
