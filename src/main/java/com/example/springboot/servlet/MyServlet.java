package com.example.springboot.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description : desc
 * @Author masz
 * @Date 2020/2/15 13:37
 */
public class MyServlet extends HttpServlet {

    //第一次请求的时候才会初始化

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req,resp);
        System.out.println("myServlet worked...");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("myServlet destroy...");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("myServlet init...");
    }
}
