package com.example.springboot.exception;

/**
 * @Description : desc
 * @Author masz
 * @Date 2020/2/14 17:29
 */
public class MyException extends RuntimeException {
    public MyException(String msg){
        super(msg);
    }
}
