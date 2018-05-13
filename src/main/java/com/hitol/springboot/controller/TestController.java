package com.hitol.springboot.controller;

import com.hitol.springboot.manager.TestManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestManager testManager;

    @RequestMapping("/queryAllStoreOrgInfo")
    private Object queryAllStoreOrgInfo(){
        return testManager.queryAllStoreOrgInfo();
    }


}
