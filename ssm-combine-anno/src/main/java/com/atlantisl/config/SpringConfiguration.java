package com.atlantisl.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(
        {
                DataSourceConfiguration.class,
                TransactionConfiguration.class,
                MyBatisConfiguration.class
        }
)
@ComponentScan("com.atlantisl.service")
public class SpringConfiguration {
}
