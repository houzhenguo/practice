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
        int size = in.readInt();
        byte[] data = new byte[size];
        in.readBytes(data);
        FooProto foo = new FooProto();
        foo.length = size;
        foo.bytes = data;
        out.add(foo);

    }
    // 存在内存泄漏
    private boolean decode() {
        int beforePos = os.position();
        try {

            int type = os.unmarshalUInt();
            int serial = os.unmarshalInt();
            Houzhenguo houzhenguo = new Houzhenguo();
            houzhenguo.unmarshal(os);
            System.out.println(houzhenguo.toString());
        }catch (Exception e) {
            os.setPosition(beforePos);
            return false;
        }
        return true;
    }
}
