package com.hitol.springboot.common;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 5){
//                    break;
                    continue;
                }
//                System.out.println(j);
            }

        }
        System.out.println(test(123));
        System.out.println(test("234"));
//        System.out.println(test(2.3F));
        StringBuffer sb = new StringBuffer("hhh");
        sb.append("123");
    }

    static void test(Float f){
        System.out.println(123);
    }
    static String test(String s){
        return s;
    }

    static Integer test(Integer i){
        return i;
    }

}
