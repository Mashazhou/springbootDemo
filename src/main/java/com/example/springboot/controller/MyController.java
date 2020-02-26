package com.example.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description : desc
 * @Author masz
 * @Date 2020/2/13 18:05
 */
@Controller
@RequestMapping("/my")
public class MyController {

    /*
     * @Description 如果只请求了 /my 方法 errorHtml() 和 error() 都会执行
     * @Date 2020/2/13 18:12
     * @Author masz
     */


    @RequestMapping(produces = {"text/html"})
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("errorHtml");
        return new ModelAndView("index");
    }

    @RequestMapping
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = new HashMap<>();
        HttpStatus status = HttpStatus.valueOf(404);
        System.out.println("error");
        return new ResponseEntity(body, status);
    }
}
