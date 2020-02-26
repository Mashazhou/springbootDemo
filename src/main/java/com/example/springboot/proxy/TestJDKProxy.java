package com.example.springboot.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description : desc
 * @Author masz
 * @Date 2019/8/29 13:37
 */
public class TestJDKProxy {
    public static void main(String[] args) throws Exception{

        //第一种
        Trade target = new TradeImpl();
        Trade proxy1 = (Trade) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new MyInvocationHandler(target));
        proxy1.doTade();

//        //第二种
//        //1，生成代理类
//        Class proxyClazz = Proxy.getProxyClass(Trade.class.getClassLoader(),Trade.class);
//        //2，得到代理类的构造函数
//        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
//        //3，根据构造函数生成代理类的实例
//        Trade proxy = (Trade)constructor.newInstance(new MyInvocationHandler(target));
//        //4， 调用
//        proxy.doTade();

    }
}

interface Trade{
    void doTade();
}

class TradeImpl implements Trade{
    @Override
    public void doTade() {
        System.out.println("do some trade...");
    }
}

class MyInvocationHandler implements InvocationHandler{

    Object target = null;

    public MyInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(">>>invoke start...");
        Object result = null;

        result = method.invoke(target,args);

        System.out.println(">>>invoke end...");
        return result;
    }
}