package com.hitol.springboot.test.sb;

import com.hitol.springboot.model.Hitol;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PropertiesTest extends BaseTest {

    @Autowired
    private Hitol hitol;

    @Test
    public void getInfo() {
        getLogger().info(" name : " + hitol.getName());
        getLogger().info(" age : " + hitol.getAge());
        getLogger().info(" value : " + hitol.getRandomValue()  );
        getLogger().info(" uuid : " + hitol.getRandomUuid());
    }

}
