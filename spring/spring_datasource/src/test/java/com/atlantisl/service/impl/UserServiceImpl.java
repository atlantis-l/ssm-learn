package com.atlantisl.service.impl;

import com.atlantisl.dao.UserDao;
import com.atlantisl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    @Override
    public void save() {
        System.out.println("userService save");
        userDao.save();
    }

    @PostConstruct
    public void init() {
        System.out.println("userService init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("userService destroy");
    }
}
