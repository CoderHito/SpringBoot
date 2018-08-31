package com.hitol.springboot.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Hitol {
    @Value("${com.hitol.name}")
    private String name;
    @Value("${com.hitol.age}")
    private int age;

    @Value("${hitol.random.value}")
    private String randomValue;

    @Value("${hitol.random.uuid}")
    private String randomUuid ;


    public String getRandomValue() {
        return randomValue;
    }

    public void setRandomValue(String randomValue) {
        this.randomValue = randomValue;
    }

    public String getRandomUuid() {
        return randomUuid;
    }

    public void setRandomUuid(String randomUuid) {
        this.randomUuid = randomUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
