package com.example.springboot.component;

import com.example.springboot.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description : desc
 * @Author masz
 * @Date 2020/2/14 18:15
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(MyException.class)
    public String handle(HttpServletRequest request){

        request.setAttribute("javax.servlet.error.status_code",400);
        request.setAttribute("fromBean",MyException.class);
        request.setAttribute("freeMsg","msg from myException");

        return "forward:/error";
    }
}
