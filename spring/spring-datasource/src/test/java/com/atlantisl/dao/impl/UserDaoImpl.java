package com.atlantisl.dao.impl;

import com.atlantisl.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    @Override
    public void save() {
        try {
            System.out.println("userDao save");
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
