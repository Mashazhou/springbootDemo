package com.example.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Description : desc
 * @Author masz
 * @Date 2020/2/15 13:42
 */
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("myListener init...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("myListener destroy...");

    }
}
