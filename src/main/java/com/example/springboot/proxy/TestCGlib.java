package com.example.springboot.proxy;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description : desc
 * @Author masz
 * @Date 2019/8/29 11:13
 */
public class TestCGlib {

    public static void main(String[] args) {

        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\sourceCode");

        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(Business.class);
        //设置回调对象
        enhancer.setCallback(new MyMethodInterceptor());
        //创建代理对象
        Business b = (Business) enhancer.create();

        System.out.println(b.trade("啦啦啦"));
    }
}

class Business{

    public Business(){
        System.out.println("Business constructor...");
    }

    public String trade(String args){
        System.out.println("args : " + args);
        System.out.println("do some trade...");
        return "giao giao ....";
    }
}

class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(">>>intercept start...");
        Object result = null;
        if("trade".equals(method.getName()))
            result = methodProxy.invokeSuper(o,objects);
        System.out.println(">>>intercept end...");

        return result;
    }
}