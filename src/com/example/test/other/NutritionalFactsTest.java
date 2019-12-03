package com.example.test.other;

public class NutritionalFactsTest {
    public static void main(String[] args) {
        NutritionalFacts n = new NutritionalFacts.Builder().sodium(10).carbo(15).
                fat(5).build();
    }
}
