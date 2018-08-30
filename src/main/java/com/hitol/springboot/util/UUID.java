package com.hitol.springboot.util;

public class UUID {
    public static String getUuid() {
        return java.util.UUID.randomUUID().toString().replace("-", "");

    }

    public static void main(String[] args) {

        System.out.println(java.util.UUID.randomUUID().toString().replace("-", "").length());
    }
}
