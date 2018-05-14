package com.hitol.springboot.controller;

import com.hitol.springboot.manager.TestManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestManager testManager;

    @RequestMapping("/index")
    public String index(){
        return "Hello";
    }

    @RequestMapping("/test")
    private Object queryAllStoreOrgInfo(){
        return testManager.queryAllStoreOrgInfo();
    }


}
