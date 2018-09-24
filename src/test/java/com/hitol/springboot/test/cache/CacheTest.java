package com.hitol.springboot.test.cache;

import com.hitol.springboot.model.UserDO;
import com.hitol.springboot.repository.UserRepository;
import com.hitol.springboot.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;

public class CacheTest extends BaseTest {


    @Autowired
    private UserRepository repository;

    /**
     * 默认的 ConcurrenMapCacheManager
     */
    @Autowired
    private CacheManager cacheManager;

    @Test
    public void testCache(){

        UserDO userDO = repository.findByName("尼古拉斯赵四");
        getLogger().info("userDo = " + userDO.toString());

        UserDO userDO2 = repository.findByName("尼古拉斯赵四");
        getLogger().info("userDo = " + userDO2.toString());

        cacheManager.getCache("users");

    }


}
/**
 * org.springframework.data.redis.serializer.SerializationException:
 * 缓存对象需要实现序列化接口
 */