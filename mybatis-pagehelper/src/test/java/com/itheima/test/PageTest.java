package com.itheima.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PageTest {

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //模拟条件user
        User user = new User();
        user.setPassword("123456");

        Page<User> userPage = PageHelper.startPage(2, 4);

        List<User> userList = mapper.findByCondition(user);

        PageInfo<User> pageInfo = new PageInfo<>(userPage);

        System.out.println(pageInfo.getPages());
        System.out.println(pageInfo.getPageNum());
        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getEndRow());
        System.out.println(pageInfo.getStartRow());
        System.out.println(pageInfo.getNextPage());
        System.out.println(pageInfo.getPrePage());

        for (User user1 : userList) {
            System.out.println(user1);
        }

        sqlSession.close();
    }
}
