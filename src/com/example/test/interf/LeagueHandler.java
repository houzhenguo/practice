package com.example.test.interf;

public class LeagueHandler implements BeanHandler<League>{
    @Override
    public void onProcess(League arg) {
        System.out.println("LeagueHandler test");
    }
}
