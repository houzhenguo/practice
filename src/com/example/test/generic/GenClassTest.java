package com.example.test.generic;

import java.util.ArrayList;
import java.util.List;

public class GenClassTest {
    public static void main(String[] args) {
        List list = getTest();
        for (Object o : list) {
            if (o.getClass() == Person.class) {
                Person p = (Person)o;
                System.out.println(p.toString());
            }

        }
    }
    public static List getTest() {
        List<Person> list = new ArrayList<>();
        Person p = new Person();
        p.name = "houzhenguo";
        p.age = 16;
        list.add(p);
        return list;
    }
    static class Person {
        String name;
        int age;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}


