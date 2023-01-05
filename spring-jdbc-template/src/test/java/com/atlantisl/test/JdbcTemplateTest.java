package com.atlantisl.test;

import com.atlantisl.config.SpringConfiguration;
import com.atlantisl.domain.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(SpringConfiguration.class)
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test1() {
        String sql = "update account set money = money + 1000 where name = ?";
        int row = jdbcTemplate.update(sql, "tom");
        System.out.println(row);
    }

    @Test
    public void test2() {
        String sql = "select * from account";
        List<Account> accountList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class));
        System.out.println(accountList);
    }

    @Test
    public void testQueryCount() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(aLong);
    }
}
