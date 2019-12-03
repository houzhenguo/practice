package com.example.test.netty;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class EventLoopGroupTest {
    public static void main(String[] args) throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
//        ChannelFuture channelFuture = bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler();
//        channelFuture.channel().bind(new InetSocketAddress(8899)).sync();
    }
}
