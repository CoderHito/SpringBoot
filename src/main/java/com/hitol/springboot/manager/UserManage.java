package com.hitol.springboot.manager;

import com.hitol.springboot.model.UserDO;
import com.hitol.springboot.model.UserPO;

import java.util.List;

public interface UserManage {
     List<UserPO> queryUserInfoList();

     UserDO findByName(String name);

     UserDO findById(Integer id);

     UserDO findUser (String name);

     void saveUser(UserDO userDO);
}
