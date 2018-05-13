package com.hitol.springboot.manager.impl;

import com.hitol.springboot.manager.TestManager;
import com.hitol.springboot.mapper.TestMapper;
import com.hitol.springboot.model.StoreOrgInfoPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class TestManagerImpl implements TestManager {

    @Resource
    private TestMapper testMapper;


    @Override
    public List<StoreOrgInfoPO> queryAllStoreOrgInfo() {
        return testMapper.queryAllStoreOrgInfo();
    }
}
