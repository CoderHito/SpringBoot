package com.hitol.springboot.manager.impl;

import com.hitol.springboot.manager.UserManage;
import com.hitol.springboot.mapper.UserMapper;
import com.hitol.springboot.model.UserDO;
import com.hitol.springboot.model.UserPO;
import com.hitol.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManageImpl implements UserManage {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository repository;


    @Override
    public List<UserPO> queryUserInfoList() {
        return userMapper.queryUserInfoList();
    }

    @Override
    public UserDO findByName(String name) {
        UserDO userDO = repository.findByName(name);
        return userDO;
    }

    @Override
    public UserDO findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public UserDO findUser(String name) {
        return repository.findUser(name);
    }
}
