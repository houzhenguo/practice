package com.example.test.clone;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.SerializationUtils;

public class FooTest {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(12);
        Foo foo = new Foo();
        foo.setId(1);
        foo.setName("tom");
        foo.setPerson(p);
        Foo foo1 = SerializationUtils.clone(foo); // 调用方法实现 deep copy
        System.out.println(foo1.getPerson().getAge());

        // 序列化测试
        byte[] bytes = SerializationUtils.serialize(foo);
        Foo foo2 = SerializationUtils.deserialize(bytes);
        System.out.println(foo2.getPerson().getAge() +"p2");

        // fastJson 可以实现序列化测试
        String fooStr = JSON.toJSONString(foo);
        System.out.println(fooStr);
        Foo foo3 = JSON.parseObject(fooStr, Foo.class);
        System.out.println("object" + foo3.getPerson().getAge());
    }
}
