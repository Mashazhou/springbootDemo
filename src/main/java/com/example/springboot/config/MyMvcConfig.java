package com.example.springboot.config;

import com.example.springboot.bean.Dog;
import com.example.springboot.bean.Person;
import com.example.springboot.component.LoginHandleIntecepter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description : desc
 * @Author masz
 * @Date 2020/2/12 14:23
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer { //
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        //防止表单重复提交，重定向到主页
        registry.addViewController("/main.html").setViewName("index");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 2.x 以上版本需要放行静态资源
        registry.addInterceptor(new LoginHandleIntecepter()).addPathPatterns("/**")
                .excludePathPatterns("/login","/login.html","/","/hello/login","/js/**","/css/**","/images/**","/fonts/**","/webjars/**");
    }

    //添加的bean的名字是 myDog
//    @Bean
//    @ConditionalOnMissingBean(value = {Person.class})
//    public Dog myDog(){
//        return new Dog();
//    }
}
