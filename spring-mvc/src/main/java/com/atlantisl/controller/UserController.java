package com.atlantisl.controller;

import com.atlantisl.dao.UserDao;
import com.atlantisl.domain.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dachuan
 */
@Controller
@RequestMapping("/user")
public class UserController {

    UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/quick")
    @ResponseBody
    public User1 quick() {
//        int a = 1 / 0;
        return User1.builder().name("dachuan").age(24).build();
    }
}
