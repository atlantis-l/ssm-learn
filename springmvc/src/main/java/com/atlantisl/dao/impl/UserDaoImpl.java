package com.atlantisl.dao.impl;

import com.atlantisl.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("userDao save");
    }
}
