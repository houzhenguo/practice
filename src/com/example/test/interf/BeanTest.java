package com.example.test.interf;

public class BeanTest {
    public static void main(String[] args) {
        LeagueHandler handler = new LeagueHandler();
        League bean = new League();
        handler.onProcess(bean);
    }
}
