package com.hitol.springboot.controller;

import com.hitol.springboot.manager.UserManage;
import com.hitol.springboot.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** 
* 
* @author hitol 
* @date 2018/8/8 下午4:59
*/ 
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserManage userManage;

    @RequestMapping("/index")
    public String index() throws Exception {
//        throw new Exception("出现异常");
        return "hello";
    }

//    @RequestMapping("queryUserInfoList")
//    public String queryUserInfoList(){
//        List<UserPO> users =  userManage.queryUserInfoList();
//        return users.toString();
//    }

    @RequestMapping("findByName")
    public String findByName(){
        UserDO userDO = userManage.findByName("zhangsan");
        return userDO.toString();
    }
    @RequestMapping("findById")
    public String findById(){
        UserDO userDO = userManage.findById(1);
        return userDO.toString();
    }

    @RequestMapping("findUser")
    public String findUser(){
        UserDO userDO = userManage.findUser("zhangsan");
        return userDO.toString();
    }

    @RequestMapping("saveUser")
    public String saveUser(){
        UserDO userDO = new UserDO();
        userDO.setId(2L);
        userDO.setName("lisi");
        userManage.saveUser(userDO);
        return null;
    }

    @RequestMapping("findOne")
    public String findOne(){
        UserDO userDO = userManage.findOne(1);
        return userDO.toString();
    }


}
