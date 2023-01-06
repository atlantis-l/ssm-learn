package com.itheima.test;

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

public class MapperTest {

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //模拟条件user
        User user = new User();
//        user.setId(3);
//        user.setUsername("dachuan");
//        user.setBirthday(LocalDate.parse("1998-10-16"));
        user.setPassword("123456");

//        int i = mapper.addUser(user);

//        sqlSession.commit();

//        System.out.println(i);

        List<User> userList = mapper.findByCondition(user);

        //模拟ids的数据
//        List<Integer> ids = new ArrayList<>();
//        ids.add(1);
//        ids.add(2);
//
//        List<User> userList = mapper.findByIds(ids);
        for (User user1 : userList) {
            System.out.println(user1);
        }

        sqlSession.close();
    }
}
