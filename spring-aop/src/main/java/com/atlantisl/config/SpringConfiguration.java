package com.atlantisl.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author dachuan
 */
@ComponentScan("com.atlantisl.aop")
@EnableAspectJAutoProxy
public class SpringConfiguration {

}
