package com.uestc.factory.pattern;

public class Chips implements Food {
    public static Chips instance = new Chips();
    public static Chips  getInstance(){
        return instance;
    }
    public void get() {
        System.out.println("This is Chips");
    }
}
