package com.atlantisl.mapper;

import com.atlantisl.entity.User;

import java.util.List;

public interface MyMapper {

    List<User> findByCondition(User user);

}
