package com.example.test.netty.demo2;

import com.example.test.netty.Houzhenguo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.ByteBuffer;


public class MyClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override // 通道已经链接了
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i< 10;i++) {
            Houzhenguo houzhenguo = new Houzhenguo();
            houzhenguo.setValue1(12+i);
            houzhenguo.setValue2(33+i);
            ctx.writeAndFlush(houzhenguo);
        }


    }
}
