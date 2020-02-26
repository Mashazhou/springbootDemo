package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;


/**
 * @Description : desc
 * @Author masz
 * @Date 2020/2/16 12:59
 */
@Controller
public class PersonController {

    @GetMapping("/person")
    public String getPersons(Model model){

        Map<Object, Object> map = new HashMap<>();
        map.put("name","艾希");
        map.put("age",122);
        map.put("sex",0);
        map.put("birth",new Date());

        Map<Object, Object> map1 = new HashMap<>();
        map1.put("name","瑟提");
        map1.put("age",123);
        map1.put("sex",1);
        map1.put("birth",new Date());

        Map<Object, Object> map2 = new HashMap<>();
        map2.put("name","厄奜六四4");
        map2.put("age",124);
        map2.put("sex",1);
        map2.put("birth",new Date());

        Map<Object, Object> map3 = new HashMap<>();
        map3.put("name","厄奜六四");
        map3.put("age",12);
        map3.put("sex",1);
        map3.put("birth",new Date());

        List<Object> list = new ArrayList<>();
        list.add(map);
        list.add(map1);
        list.add(map2);
        list.add(map3);

        model.addAttribute("persons",list);
        return "editable_table";
    }
}
