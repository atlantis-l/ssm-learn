package com.atlantisl.service;

import com.atlantisl.entity.User;
import com.atlantisl.mapper.MyMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("myService")
public class MyService {

    private final MyMapper myMapper;

    public MyService(MyMapper myMapper) {
        this.myMapper = myMapper;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
    public List<User> getUser(User user) {
        return myMapper.findByCondition(user);
//        return null;
    }
}
