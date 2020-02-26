package com.example.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description : desc
 * @Author masz
 * @Date 2020/2/12 16:57
 */
public class LoginHandleIntecepter implements HandlerInterceptor {

    /*
     * 拦截器和过滤器执行顺序：
        1、Filter.init();
        2、Filter.doFilter(); before doFilter
        3、HandlerInterceptor.preHandle();
        4、Controller方法执行
        5、HandlerInterceptor.postHandle();
        6、DispatcherServlet视图渲染
        7、HandlerInterceptor.afterCompletion();
        8、Filter.doFilter(); after doFilter
        9、Filter.destroy();
     */



    /*
     * Filter和Interceptor的区别
     *
        Filter是基于函数回调（doFilter()方法）的，而Interceptor则是基于Java反射的（AOP思想）。
        Filter依赖于Servlet容器，而Interceptor不依赖于Servlet容器。
        Filter对几乎所有的请求起作用，而Interceptor只能对action请求起作用。 （action请求:对控制层的请求）
        Interceptor可以访问Action的上下文，值栈里的对象，而Filter不能。
        在action的生命周期里，Interceptor可以被多次调用，而Filter只能在容器初始化时调用一次
     */


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("username");
        if(null == user){
            request.setAttribute("msg","您没有权限");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;

        }else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
