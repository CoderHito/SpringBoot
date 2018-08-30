package com.hitol.springboot.controller;

import com.hitol.springboot.model.UserDO;
import com.hitol.springboot.repository.UserRepository;
import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
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

    private Logger logger = LoggerFactory.getLogger(getClass());

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
    public void saveUserList() {
        List<UserDO> list = new ArrayList<>();

        long count = userRepository.count();

        for (int i = (int) count; i < count + 10; i++) {
            UserDO userDO = new UserDO();
            userDO.setId(Long.valueOf(i));
            userDO.setName("zhaosi" + i);
            list.add(userDO);
        }
        List<UserDO> result = userRepository.saveAll(list);
        for (UserDO userDO : result) {
            logger.info(userDO.toString());
        }
    }


    @Test
    public void getOne() {
        UserDO userDO = userRepository.getOne(20L);
        logger.info(userDO.toString());
        userDO.setName("尼古拉斯赵四");
        userRepository.save(userDO);

        /**
         * Hibernate: select userdo0_.id as id1_0_0_, userdo0_.name as name2_0_0_ from auth_user userdo0_ where userdo0_.id=?
         * UserDO{id=20, name='zhaosi20'}
         * Hibernate: select userdo0_.id as id1_0_0_, userdo0_.name as name2_0_0_ from auth_user userdo0_ where userdo0_.id=?
         * Hibernate: update auth_user set name=? where id=?
         */
    }

    @Test
    public void findOne() {
        /**
         * findOne 接口是1.xx版本中的方法
         * 2.xx版本中使用  Optional<T> findById(ID var1);
         *
         */
        Optional<UserDO> optional = userRepository.findById(10L);

        UserDO userDO = optional.get();
        logger.info(optional.toString());
        userDO.setName("尼古拉斯赵五");
        userRepository.save(userDO);

        /**
         * Hibernate: select userdo0_.id as id1_0_0_, userdo0_.name as name2_0_0_ from auth_user userdo0_ where userdo0_.id=?
         * Optional[UserDO{id=10, name='尼古拉斯赵四'}]
         * Hibernate: select userdo0_.id as id1_0_0_, userdo0_.name as name2_0_0_ from auth_user userdo0_ where userdo0_.id=?
         * Hibernate: update auth_user set name=? where id=?
         */
    }

    @Test
    public void findAll() {
//        UserDO userDO = userRepository.findOne(10L);
        List<UserDO> list = userRepository.findAll();
        for (UserDO userDO : list) {
            logger.info(userDO.toString());
        }
    }


    /**
     * 排序-查询
     */
    @Test
    public void sortQuery() {
        /**
         * 根据id排序
         */
        Sort defaultSort = new Sort(Sort.Direction.DESC, "id");

        /**
         * 多个排序条件
         */
        Sort.Order nameDesc = new Sort.Order(Sort.Direction.DESC, "name");
        Sort.Order idDesc = new Sort.Order(Sort.Direction.DESC, "id");

        List<Sort.Order> orderList = new ArrayList<>();
        orderList.add(idDesc);
        orderList.add(nameDesc);

//        List<UserDO> list = userRepository.findAll(defaultSort);
        List<UserDO> list = userRepository.findAll(new Sort(orderList));
        for (UserDO userDO : list) {
            logger.info(userDO.toString());
        }

    }

    /**
     * 分页查询
     */
    @Test
    public void pageTest() {

        int currentPage = 0;
        int pageSize = 10;

        Page<UserDO> page = userRepository.findAll(new PageRequest(currentPage, pageSize));
        logger.info(" 总记录数  totalElements = " + page.getTotalElements());
        logger.info(" 总页数  totalPages = " + page.getTotalPages());
        logger.info(" 当前页  number = " + page.getNumber());
        logger.info(" 当前页记录数 size = " + page.getSize());
        logger.info(" 当前页内容  Content = " + page.getContent());
    }
}
