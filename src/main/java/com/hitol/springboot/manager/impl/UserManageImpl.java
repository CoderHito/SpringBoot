package com.hitol.springboot.manager.impl;

import com.hitol.springboot.manager.UserManage;
import com.hitol.springboot.mapper.UserMapper;
import com.hitol.springboot.model.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManageImpl implements UserManage {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<UserPO> queryUserInfoList() {
        return userMapper.queryUserInfoList();
    }
}
