package com.example.test.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FooTest {
    public static void main(String[] args) throws Exception{
        Class<?> cls = Class.forName("com.example.test.reflect.Foo");
        Constructor constructor = cls.getDeclaredConstructor();
        constructor.setAccessible(true); // 私有构造方法也可以创建
        Foo foo = (Foo) constructor.newInstance(); // 安全性问题

        Field idField = cls.getDeclaredField("id");
        idField.setAccessible(true);
        idField.set(foo, 22);

        Field nameField = cls.getDeclaredField("name");
        nameField.setAccessible(true); // 当private修饰时候使用
        nameField.set(foo, "hello");

        Method method = cls.getDeclaredMethod("print");
        method.setAccessible(true); // 当private 修饰时候使用
        method.invoke(foo); // out: Foo{id=22, name='hello'}

        Field[] fields = cls.getFields(); // 获取所有的public的Field 包括从父类继承来的public
        for (Field f : fields) {
            System.out.println(f.getName()); // age
        }
        Method[] methods = cls.getMethods();
        for (Method m : methods) {
            System.out.println(m.getName()); // contains play(extends from father class)
        }

        // invoke param method
        Method sayMethod = cls.getDeclaredMethod("say", String.class, int.class); // 获取say方法，参数类型为xx
        sayMethod.setAccessible(true);
        sayMethod.invoke(foo, "tom", 23);


    }
}
