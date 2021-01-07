package com.xu.module.algorithm;

public class User {
    int i = 1;

    public User() {
        int x = getValue();
        System.out.println("User中getValue值："+x);
    }

    public int getValue() {
        return i;
    }
}
