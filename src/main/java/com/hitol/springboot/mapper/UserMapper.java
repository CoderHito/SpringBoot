package com.hitol.springboot.mapper;

import com.hitol.springboot.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from auth_user where name = #{name}")
    User findByName(@Param("name") String name);

//    @Insert("insert into auth_user (id,name) values(#{id},#{name}) ")
//    int insertUser(@Param("name") String name,@Param("id") int id);


    @Insert("insert into auth_user(id,name) values(#{id},#{name})")
    int insertUser(User user);
}
