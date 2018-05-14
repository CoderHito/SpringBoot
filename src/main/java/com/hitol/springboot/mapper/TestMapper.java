package com.hitol.springboot.mapper;

import com.hitol.springboot.model.StoreOrgInfoPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Repository(value = "testMapper")
@Mapper
public interface TestMapper {

    List<StoreOrgInfoPO> queryAllStoreOrgInfo();
}
