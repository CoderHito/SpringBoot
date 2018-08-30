package com.hitol.springboot.manager.impl;

import com.hitol.springboot.manager.UserManage;
import com.hitol.springboot.mapper.UserMapper;
import com.hitol.springboot.model.UserDO;
import com.hitol.springboot.model.UserPO;
import com.hitol.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManageImpl implements UserManage {
//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private UserRepository repository;


    @Override
    public List<UserPO> queryUserInfoList() {
        return null;
//                userMapper.queryUserInfoList();
    }

    @Override
    public UserDO findByName(String name) {
//        UserDO userDO = repository.findByName(name);
//        return userDO;
        return null;
    }

    @Override
    public UserDO findById(Integer id) {
//        return repository.findById(id);
        return null;
    }

    @Override
    public UserDO findUser(String name) {
        return null;
//                repository.findUser(name);
    }

    @Override
    public void saveUser(UserDO userDO) {
        repository.save(userDO);
    }

    @Override
    public UserDO findOne(Integer id) {
//        UserDO userDO = repository.findOne(id);
//        return userDO;
        return null;
    }
}
