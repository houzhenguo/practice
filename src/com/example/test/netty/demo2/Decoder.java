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
        // 处理头部被压缩的问题
        byte[] headdata = new byte[4]; // 这里需要的修改，不能写死。 这个可以放在外面 4个字节为最大长度
        in.readBytes(headdata);
        in.resetReaderIndex();
        OctetsStream os = new OctetsStream();
        os.wraps(headdata);
        int posBegin = os.position();
        int size = os.unmarshalUInt(); // 解析出头部长度
        int posEnd = os.position();


        in.markReaderIndex();
        //int size = in.readByte(); // size -> int
        byte[] data = new byte[size + posEnd  - posBegin]; // 这里是加上 bean 的长度那个字节
        in.resetReaderIndex();
        in.readBytes(data);

        Houzhenguo houzhenguo= new Houzhenguo();
        houzhenguo.unmarshal(OctetsStream.wrap(data));
        out.add(houzhenguo);
    }
}
