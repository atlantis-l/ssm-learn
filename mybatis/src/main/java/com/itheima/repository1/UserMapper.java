package com.itheima.repository1;

import com.itheima.entity.User1;

import java.io.IOException;
import java.util.List;

public interface UserMapper {

    public List<User1> findAll() throws IOException;

    public User1 findById(int id);

}
