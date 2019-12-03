package com.example.pattern.observer;

public class Display1Observer implements Observer{
    String name;
    public Display1Observer(String name) {
        this.name = name;
    }
    @Override
    public void update(int a, int b) {
        System.out.println(name + " 01号收到 a is" + a +", b is " +b);
    }
}
