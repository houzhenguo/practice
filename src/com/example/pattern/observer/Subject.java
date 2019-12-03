package com.example.pattern.observer;


public interface Subject {
    void register(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();

}
