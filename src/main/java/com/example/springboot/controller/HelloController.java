package com.example.springboot.controller;

import com.example.springboot.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description : desc
 * @Author masz
 * @Date 2020/2/9 14:48
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private ConfigurableApplicationContext context;


    /**
     * @RequestMapping
     * 方法的返回值是字符串的情况：
     *  1，"xxx" 解析为一个具体的页面
     *  2，"redirect:xxx" 重定向到xxx方法
     *  3，"forward:xxx" 转发到xxx方法
     */


    @ResponseBody
    @RequestMapping("/test")
    public String showHello(){
        return "nihao 你好世界！";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model, HttpSession session){
//        String[] s = context.getBeanDefinitionNames(); //所有bean
//        for (String t : s){
//
//            if(t.contains("og")){
//                System.out.println("og list >>>");
//                System.out.println(t);
//
//            }
//
//            if(t.contains("erson")){
//                System.out.println("erson list >>>");
//                System.out.println(t);
//            }
//        }
        if("msz".equals(username) && "1".equals(password)){
            session.setAttribute("username",username);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","用户密码错误");
            return "login";
        }


    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "/login.html";
    }

    @RequestMapping("/testExp")
    public String testException(HttpSession session){
        if(true){
            throw new MyException("这是自定义异常");

        }
        return "";
    }



}
