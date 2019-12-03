package com.example.test.other;

/**
 *
 */
public class NutritionalFacts {
    private final int sodium;
    private final int fat;
    private final int carbo;

    public int getSodium(){
        return sodium;
    }

    public int getFat(){
        return fat;
    }

    public int getCarbo(){
        return carbo;
    }

    public static class Builder {
        private int sodium;
        private int fat;
        private int carbo;

        public Builder sodium(int s) {
            this.sodium = s;
            return this;
        }

        public Builder fat(int f) {
            this.fat = f;
            return this;
        }

        public Builder carbo(int c) {
            this.carbo = c;
            return this;
        }

        public NutritionalFacts build() {
            return new NutritionalFacts(this);
        }
    }

    private NutritionalFacts(Builder b) {
        this.sodium = b.sodium;
        this.fat = b.fat;
        this.carbo = b.carbo;
    }
}
