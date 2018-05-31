package com.hitol.springboot.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultHandler(HttpServletRequest req, Exception e) throws Exception{
           ModelAndView modelAndView = new ModelAndView();
           modelAndView.addObject("exception",e);
           modelAndView.addObject("url",DEFAULT_ERROR_VIEW);
           modelAndView.setViewName(DEFAULT_ERROR_VIEW);
           return modelAndView;
    }
}

