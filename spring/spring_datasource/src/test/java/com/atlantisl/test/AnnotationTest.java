package com.atlantisl.test;

import com.atlantisl.config.SpringConfiguration;
import com.atlantisl.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;

@SpringJUnitConfig(SpringConfiguration.class)
//@SpringJUnitConfig(locations = {"classpath:spring.xml"})
public class AnnotationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void test1() {
        userService.save();
        System.out.println(dataSource);
    }
}
