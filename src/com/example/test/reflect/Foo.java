package com.example.test.reflect;

public class Foo extends FooBase{
    private int id;
    private String name;
    private Foo(){} // private constructor

    @Override
    public String toString() {
        return "Foo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    private void print() {
        System.out.println(toString());
    }

    // say method with two params
    private void say(String name, int age) {
        System.out.println("I am "+name+" and "+age+" years old");
    }
    // say method with only one param
    private void say(String name) {
        System.out.println("I am "+name);
    }
}
