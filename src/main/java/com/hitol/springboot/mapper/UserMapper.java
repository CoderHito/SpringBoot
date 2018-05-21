package com.hitol.springboot.mapper;

import com.hitol.springboot.model.UserPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<UserPO> queryUserInfoList();
}
