package com.atlantisl.test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class DataSourceTest {
    /**
     * c3p0数据源
     */
    @Test
    public void test1() {
        try {
            ResourceBundle c3p0 = ResourceBundle.getBundle("c3p0");
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(c3p0.getString("driverClassName"));
            dataSource.setJdbcUrl(c3p0.getString("url"));
            dataSource.setUser(c3p0.getString("username"));
            dataSource.setPassword(c3p0.getString("password"));
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            connection.close();
        } catch (PropertyVetoException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * druid数据源
     */
    @Test
    public void test2() {
        try {
            Properties properties = new Properties();
            String propsPath = "druid.properties";
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propsPath);
            properties.load(inputStream);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test3() {
        try {
            String path = "spring.xml";
            ApplicationContext context = new ClassPathXmlApplicationContext(path);
            DataSource dataSource = context.getBean(DataSource.class);
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
