package com.hitol.springboot.manager;

import com.hitol.springboot.model.UserPO;

import java.util.List;

public interface UserManage {
     List<UserPO> queryUserInfoList();
}
