package com.example.test.netty.demo2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import jane.core.OctetsStream;

import java.util.List;

public class Decoder2 extends ByteToMessageDecoder {
    OctetsStream _os = new OctetsStream();
    private int _psize = -1; // 当前解析协议的大小
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        // 最原始的解析方式
        if (!_os.empty()) { // 上次解析有残留
            int r = in.readableBytes();
            int s = _os.size();
            int n = Math.min(_psize < 0 ? 15 - s : _psize - _os.remain(), r);
            _os.resize(s + n);
            //in.getBytes(s, _os, s, n);
        }


        // new begin
        int n = in.writerIndex();
        OctetsStream os;
        if (in.hasArray()) {
            os = OctetsStream.wrap(in.array(), in.readerIndex(), n); // array, begin = read, end = write
            in.skipBytes(n - in.readerIndex()); // set po
        }else {
            n = in.readableBytes();
            byte[] buf = new byte[n];
            //in.reader
        }


    }
}
