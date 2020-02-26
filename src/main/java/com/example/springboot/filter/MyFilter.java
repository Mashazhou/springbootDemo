package com.example.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Description : desc
 * @Author masz
 * @Date 2020/2/15 13:34
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("myFilter init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("myFilter worked...");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("myFilter destroy...");
    }
}
