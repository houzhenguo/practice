package com.example.test.juc;

import java.util.concurrent.atomic.AtomicReferenceArray;

public class AtomicReferenceArrayTest {
    public static void main(String[] args) {
        AtomicReferenceArray<Foo> foo = new AtomicReferenceArray<Foo>(2);
        foo.compareAndSet(1, null, new Foo(22));
        System.out.println(foo.get(1).toString());
    }
}
class Foo {
    int id;
    public Foo(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "id=" + id +
                '}';
    }
}
