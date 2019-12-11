package com.example.test.netty;

import jane.core.NetManager;
import jane.core.Octets;
import jane.core.OctetsStream;

public class Test {
    public static void main(String[] args) throws Exception{
//        Houzhenguo houzhenguo = new Houzhenguo();
//        houzhenguo.setValue1(11);
//        houzhenguo.setValue2(222L);
//        Octets os = houzhenguo.marshal(new Octets());
//
//
//        Houzhenguo h = new Houzhenguo();
//        h.unmarshal(new OctetsStream(os));
//        System.out.println(h.toString());

        // Test 序列化以及反序列化
        Houzhenguo h = new Houzhenguo();
        h.setValue1(666);
        h.setValue2(23);
        BeanCodec codec = new BeanCodec();
        boolean f=  codec.decodeProtocol(codec.enCode(h));

        //jane.core.BeanCodec




    }
}
