package com.example.test.netty.demo2;

import com.example.test.interf.Bean;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class Encoder extends MessageToByteEncoder<FooProto> {
    @Override
    protected void encode(ChannelHandlerContext ctx, FooProto msg, ByteBuf out) throws Exception {
        System.out.println("encode invoke");
        out.writeInt(msg.length);
        out.writeBytes(msg.bytes);
    }
}
