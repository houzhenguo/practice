package com.example.workpractice;

public class People extends P{
    public static final String name ;
    public int age =12;
    static {
        name = "hello";
    }
    @Override
    public void play() {
        System.out.println("play");
    }
    public void say (){
        System.out.println("say");
    }
    static public void sing(){}

}
