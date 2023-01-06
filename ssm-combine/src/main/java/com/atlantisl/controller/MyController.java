package com.atlantisl.controller;

import com.atlantisl.entity.User;
import com.atlantisl.service.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("myController")
@RequestMapping("/user")
public class MyController {

    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping(value = "/{name}")
    @ResponseBody
    public List<User> getUser(@PathVariable("name") String name) {
        if (name == null) {
            return null;
        }
        return myService.getUser(User.builder().name(name).build());
    }
}
