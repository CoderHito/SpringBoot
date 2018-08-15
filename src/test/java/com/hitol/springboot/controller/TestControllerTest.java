//package com.hitol.springboot.controller;
//
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mock.web.MockServletContext;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.context.WebApplicationContext;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@WebAppConfiguration
//
//public class TestControllerTest {
//        /**
//         * mockMvc: 这个对象是Controller单元测试的关键，它的初始化也是在setup方法里面。
//         mockMvc.perform: 发起一个http请求。
//         post(url): 表示一个post请求，url对应的是Controller中被测方法的Rest url。
//         param(key, value): 表示一个request parameter，方法参数是key和value。
//         andDo（print()）: 表示打印出request和response的详细信息，便于调试。
//         andExpect（status().isOk()）: 表示期望返回的Response Status是200。
//         andExpect（content().string(is（expectstring））: 表示期望返回的Response Body内容是期望的字符串。
//         */
////        private MockMvc mockMvc;
////        //用于声明一个ApplicationContext集成测试加载WebApplicationContext。作用是模拟ServletContext
////        @Autowired
////        private WebApplicationContext wac;
////
//
//}
