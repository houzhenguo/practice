package com.example.pattern.observer;

import java.util.LinkedList;
import java.util.List;

public class WeatherDataSubject implements Subject{
    public List<Observer> observers = new LinkedList<>();
    int a;
    int b;
    @Override
    public void register(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer ob : observers) {
            ob.update(this.a, this.b);
        }
    }
    public void change(int a, int b) {
        this.a = a;
        this.b = b;
        notifyObservers();
    }
}
