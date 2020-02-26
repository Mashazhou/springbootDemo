package com.example.springboot.config;

import com.example.springboot.filter.MyFilter;
import com.example.springboot.listener.MyListener;
import com.example.springboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.Filter;

/**
 * @Description : desc
 * @Author masz
 * @Date 2020/2/15 13:33
 */
@Configuration
public class MyServerConfig {

    /**
     * 注册三大组件 (监听器>过滤器>serlvet，配置的时候要注意先后顺序,这里springboot默认这个顺序了)
     */

    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean<MyServlet> servletServletRegistrationBean = new ServletRegistrationBean<>(new MyServlet(),"/myServlet");
        return servletServletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<MyFilter>(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/myServlet"));
        return filterRegistrationBean;
    }


    /* 分类：

        按监听的对象划分，可以分为:

        ServletContext对象监听器
        HttpSession对象监听器
        ServletRequest对象监听器


        按监听的事件划分:

        对象自身的创建和销毁的监听器
        对象中属性的创建和消除的监听器
        session中的某个对象的状态变化的监听器
    */

    //Session对象是在客户端第一次请求服务器的时候创建的

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(new MyListener());
        return servletListenerRegistrationBean;
    }


}
