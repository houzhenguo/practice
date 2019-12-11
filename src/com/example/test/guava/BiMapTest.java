package com.example.test.guava;

import com.google.common.base.Joiner;
import com.google.common.collect.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BiMapTest {
    public static void main(String[] args) {
        // BiMap
        BiMap<Integer, String> biMap = HashBiMap.create();
        biMap.put(2,"b");
        biMap.put(1,"a");
        biMap.put(3,"c");
        //biMap.forcePut(4,"c");
        biMap.inverse().forEach((k,v)->{ // 反转
            System.out.println("k1 is " + k +" and v1 is" + v);
        });
        biMap.forEach((k,v)->{
            System.out.println("k is" + k +"and v is" + v);
        });
        // list
        List<String> list = Lists.newArrayList();

        Map<String, String> map = Maps.newHashMap();


        Multimap<String,Integer> map1 = ArrayListMultimap.create();
        map1.put("aa", 1);
        map1.put("aa", 2);

        List<String> list1 = new ArrayList<String>();
        list1.add("aa");
        list1.add("bb");
        list1.add("cc");
        String result = Joiner.on("-").join(list1);

    }
}
