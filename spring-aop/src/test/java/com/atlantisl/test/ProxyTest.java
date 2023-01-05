package com.atlantisl.test;

import com.atlantisl.aop.Target;
import com.atlantisl.aop.TargetInterface;
import com.atlantisl.config.SpringConfiguration;
import com.atlantisl.proxy.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.lang.reflect.Proxy;

//@SpringJUnitConfig(locations = {"classpath:spring.xml"})
@SpringJUnitConfig(SpringConfiguration.class)
public class ProxyTest {

    @Autowired
    private TargetInterface target;

    @Test
    public void jdkProxy() {
        Target target = new Target();
        Advice advice = new Advice();
        TargetInterface o = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    advice.before();
                    Object invoke = method.invoke(target, args);
                    advice.after();
                    return invoke;
                });
        System.out.println(o.getClass());
        o.save();
        o.run();
    }

    @Test
    public void cglibProxy() {
        Target target = new Target();
        Advice advice = new Advice();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Target.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            advice.before();
            Object invoke = method.invoke(target, objects);
            advice.after();
            return invoke;
        });
        Target proxy = (Target) enhancer.create();
        System.out.println(proxy.getClass().getSuperclass());
        proxy.save();
        proxy.run();
    }

    @Test
    public void springAopTest() {
        target.run();
        target.save();
    }
}
