package com.example.pattern.observer;

public class DisplayObserver implements Observer{
    String name;
    public DisplayObserver(String name) {
        this.name = name;
    }
    @Override
    public void update(int a, int b) {
        System.out.println(name + " 收到 a is" + a +", b is " +b);
    }
}
