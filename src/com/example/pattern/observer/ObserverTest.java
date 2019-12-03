package com.example.pattern.observer;

public class ObserverTest {
    public static void main(String[] args) {
        Observer o1 = new DisplayObserver("zhangsan");
        Observer o2 = new DisplayObserver("lisi");
        Observer o3 = new Display1Observer("wangwu");
        WeatherDataSubject subject = new WeatherDataSubject();
        subject.register(o1);
        subject.register(o2);
        subject.register(o3);
        subject.change(1,2);
    }
}
