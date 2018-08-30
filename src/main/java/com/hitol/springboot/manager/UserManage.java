package com.hitol.springboot.manager;

import com.hitol.springboot.model.UserDO;


public interface UserManage {
//     List<UserPO> queryUserInfoList();

     UserDO findByName(String name);

     UserDO findById(Integer id);

     UserDO findUser (String name);

     void saveUser(UserDO userDO);

     UserDO findOne (Integer id);

}
