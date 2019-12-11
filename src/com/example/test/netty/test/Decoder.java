package com.example.test.netty.test;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import io.netty.handler.codec.ByteToMessageDecoder;
import jane.core.OctetsStream;

import java.util.List;

public class Decoder extends ByteToMessageDecoder {
    protected final OctetsStream _os = new OctetsStream(); // 用于解码器的缓存
    protected int                   _psize = -1;              // 当前数据缓存获得的协议大小， -1 表示没有获取到
    protected int                   _ptype;                   // 当前数据缓存中获得的协议类型
    protected int                   _pserial;                 // 当前数据缓存中协议序列号
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

    }
}
