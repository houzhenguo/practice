package com.example.test.other;

import org.junit.Test;

public class JunitTest {
    @Test
    public void test(){
        assert "aa".endsWith("a");
    }
}
