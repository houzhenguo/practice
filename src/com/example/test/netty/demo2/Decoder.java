package com.example.test.netty.demo2;

import com.example.test.clone.Foo;
import com.example.test.netty.Houzhenguo;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.ReplayingDecoder;
import jane.core.Octets;
import jane.core.OctetsStream;

import java.util.List;

public class Decoder extends ReplayingDecoder<Void>{
    OctetsStream os = new OctetsStream();
    int count;
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("decode invoke count "+(++count));
        byte type = in.readByte();
        byte serial = in.readByte();
        in.markReaderIndex();
        int size = in.readByte(); // size -> int
        byte[] data = new byte[size+1]; // 这里是加上 bean 的长度那个字节
        in.resetReaderIndex();
        in.readBytes(data);

        Houzhenguo houzhenguo= new Houzhenguo();
        houzhenguo.unmarshal(OctetsStream.wrap(data));
        out.add(houzhenguo);
    }
}
