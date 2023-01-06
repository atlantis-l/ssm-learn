package com.atlantisl.service;

import com.atlantisl.entity.User;
import com.atlantisl.mapper.MyMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("myService")
public class MyService {

    private final MyMapper myMapper;

    public MyService(MyMapper myMapper) {
        this.myMapper = myMapper;
    }

    public List<User> getUser(User user) {
        return myMapper.findByCondition(user);
    }
}
