package com.example.springboot.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Dog {

    private String name;
    private Integer age;

    public Dog(){}

    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<>();
    }
}


