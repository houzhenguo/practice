package com.example.test.clone;

import java.io.Serializable;

public class Person implements Serializable {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
