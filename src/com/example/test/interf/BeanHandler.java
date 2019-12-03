package com.example.test.interf;

public interface BeanHandler <B extends Bean<B>>{
    void onProcess(B arg);

    default void process(Bean<?> bean){
        onProcess((B)bean);
    }
}
