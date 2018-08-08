package com.hitol.springboot.controller;

import com.hitol.springboot.manager.UserManage;
import com.hitol.springboot.model.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserManage userManage;

    @RequestMapping("/index")
    public String index() throws Exception {
//        throw new Exception("出现异常");
        return "Hello123";
    }

    @RequestMapping("queryUserInfoList")
    public String queryUserInfoList(){
        List<UserPO> users =  userManage.queryUserInfoList();
        return users.toString();
    }



}
