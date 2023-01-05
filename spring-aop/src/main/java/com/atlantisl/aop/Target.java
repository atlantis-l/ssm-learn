package com.atlantisl.aop;

import org.springframework.stereotype.Component;

/**
 * @author dachuan
 */
@Component("target")
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save running...");
//        throw new RuntimeException();
    }

    @Override
    public void run() {
        System.out.println("run running...");
    }
}
