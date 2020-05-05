package com.uestc.factory.pattern;

public class Egges implements Food{
    public static Egges instance = new Egges();
    public static Egges getInstance() {
        return instance;
    }
    public void get() {
        System.out.println("This is egges");
    }
}
