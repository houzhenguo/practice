package com.example.test.netty.demo2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.ByteBuffer;
import java.util.UUID;

/**
 *  自定义的Handler
 */

public class MyServerHandler extends SimpleChannelInboundHandler<FooProto> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FooProto msg) throws Exception {
        System.out.println("server length "+ msg.length);
        System.out.println("server bytes" + new String(msg.bytes));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        cause.printStackTrace();
        ctx.close();
    }
}
