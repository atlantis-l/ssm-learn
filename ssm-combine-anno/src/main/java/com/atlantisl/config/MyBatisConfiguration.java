package com.atlantisl.config;

import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@PropertySource("classpath:mybatis.properties")
@MapperScan("${mybatis.basePackage}")
public class MyBatisConfiguration {

    @Value("${mybatis.typeAliasesPackage}")
    private String typeAliasesPackage;

    @Bean("sqlSessionFactoryBean")
    public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage(typeAliasesPackage);
        factoryBean.setPlugins(new PageInterceptor());
        return factoryBean;
    }
}
