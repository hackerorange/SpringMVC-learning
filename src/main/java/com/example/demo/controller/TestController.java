package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @RequestMapping("test")
    public User getUser() {

        User user = new User();
        user.setName("张三");
        user.setAge(20);
        return user;
    }

    @RequestMapping("test2")
    public String test2(@RequestBody User user) {
        System.out.println(user.getName());
        System.out.println(user.getAge());
        return "SUCCESS";
    }

    @RequestMapping("test3")
    public String test3() {
        return "SUCCESS";
    }


}
