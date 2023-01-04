package com.atlantisl.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dachuan
 */
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String configLocation = sce.getServletContext().getInitParameter("contextConfigLocation");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        sce.getServletContext().setAttribute("applicationContext", context);
        System.out.println("Spring容器创建完成...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
