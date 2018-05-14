package com.hitol.springboot.mappers;

import com.hitol.springboot.model.StoreOrgInfoPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "testMapper")
public interface TestMapper {

    List<StoreOrgInfoPO> queryAllStoreOrgInfo();
}
