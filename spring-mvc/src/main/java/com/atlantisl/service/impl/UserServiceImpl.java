package com.atlantisl.service.impl;

import com.atlantisl.dao.UserDao;
import com.atlantisl.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author dachuan
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("userService save");
        userDao.save();
    }

    public void init() {
        System.out.println("userService init");
    }

    public void destroy() {
        System.out.println("userService destroy");
    }
}
