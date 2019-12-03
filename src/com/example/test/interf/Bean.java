package com.example.test.interf;

import java.io.Serializable;

public abstract class Bean<B extends Bean<B>> implements Serializable {

    public abstract B createBean();

}
