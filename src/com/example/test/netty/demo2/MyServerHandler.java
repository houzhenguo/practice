package com.example.test.netty.demo2;

import com.example.test.netty.Houzhenguo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.ByteBuffer;
import java.util.UUID;

/**
 *  自定义的Handler
 */

public class MyServerHandler extends SimpleChannelInboundHandler<Houzhenguo> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Houzhenguo msg) throws Exception {
        System.out.println("server recv value1  "+ msg.getValue1());
        System.out.println("server recv value2  "+ msg.getValue2());
        System.out.println("server recv value3  "+ msg.getValue3());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        cause.printStackTrace();
        ctx.close();
    }
}
