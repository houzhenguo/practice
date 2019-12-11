package com.example.test.netty.demo2;

import com.example.test.netty.Houzhenguo;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import jane.core.Octets;

public class Encoder extends MessageToByteEncoder<Houzhenguo> {
    @Override
    protected void encode(ChannelHandlerContext ctx,Houzhenguo  bean, ByteBuf out) throws Exception {
        System.out.println("houzhenguo encode invoke");
        Octets os = new Octets(bean.initSize());
        bean.marshal(os.marshalUInt(bean.type()).marshal(bean.serial()));

        out.writeBytes(os.getBytes());
    }
}
