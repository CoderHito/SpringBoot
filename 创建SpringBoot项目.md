# 创建Spring Boot项目

1.创建一个java  maven 项目
2.pom.xml文件中配置

	<parent>  
	    <groupId>org.springframework.boot</groupId>  
	    <artifactId>spring-boot-starter-parent</artifactId>  
	    <version>1.4.0.RELEASE</version>  
	</parent>  
	  
	<dependencies>  
	    <dependency>  
	        <groupId>org.springframework.boot</groupId>  
	        <artifactId>spring-boot-starter-web</artifactId>  
	    </dependency>  
	</dependencies>  

3.新建一个Java类

	package com.hitol.controller;
	
	
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.ResponseBody;
	import org.springframework.web.bind.annotation.RestController;
	
	//@Controller
	@RestController
	@SpringBootApplication
	public class SimpleController {
	
	    @RequestMapping("/")
	    @ResponseBody
	    String index (){
	        return "Hello Spring Boot123";
	    }
	
	    public static void main(String[] args) {
	        SpringApplication.run(SimpleController.class,args);
	    }
	}
	

4.运行main方法

5.访问 http://localhost:8080