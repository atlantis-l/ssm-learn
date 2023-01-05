package com.atlantisl.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.atlantisl")
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {
}
