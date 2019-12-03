package com.example.test.interf;

public class League extends Bean<League>{

    @Override
    public League createBean() {
        return new League();
    }

}
