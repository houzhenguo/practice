package com.example.test.interf;

public interface IFoo {
    void test();

    public static void main(String[] args) {
        IFoo foo = new IFoo() {
            @Override
            public void test() {
                System.out.println("aaa");
            }
        };
        foo.test();
    }
}
