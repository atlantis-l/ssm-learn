package com.atlantisl.proxy;

public class Advice {
    public void before() {
        System.out.println("before running...");
    }

    public void after() {
        System.out.println("after running...");
    }
}
