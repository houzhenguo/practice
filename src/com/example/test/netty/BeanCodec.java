package com.example.test.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import jane.core.Bean;
import jane.core.MarshalException;
import jane.core.Octets;
import jane.core.OctetsStream;

import java.util.List;

public class BeanCodec extends ByteToMessageDecoder {
    protected final OctetsStream    _os = new OctetsStream(); // 用于解码器的缓存
    protected int                   _psize = -1;              // 当前数据缓存获得的协议大小， -1 表示没有获取到
    protected int                   _ptype;                   // 当前数据缓存中获得的协议类型
    protected int                   _pserial;                 // 当前数据缓存中协议序列号

    // 先练习 解码器

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

    }
    public OctetsStream enCode(Bean<?> bean) {
        Octets os = new Octets(bean.initSize());
        bean.marshal(os.marshalUInt(bean.type()).marshal(bean.serial()));

        return OctetsStream.wrap(os);
    }

    public  boolean decodeProtocol(OctetsStream os) throws MarshalException {
        if (_psize < 0) {
            int pos = os.position();
            try {
                System.out.println("pos1" + pos);
                _ptype = os.unmarshalUInt(); // 解析类型
                System.out.println("after type pos2 " + os.position());
                _pserial = os.unmarshalInt(); // 解析序列号
                System.out.println("after type serial " + os.position());
                int ppos = os.position();
                int psize = os.unmarshalUInt(); // 获取bean大小
                System.out.println("psize" + psize +"and pos" + os.position());
                _psize = os.position() - ppos + psize;
                os.setPosition(ppos);

            }catch (MarshalException e) {
                os.setPosition(pos);
                return false;
            }
            if (_psize > os.remain()) {
                return false;
            }
            Bean<?> bean = createBean();
            int pos1 = os.position();
            bean.unmarshal(os);
            System.out.println(os.position());
            System.out.println(bean.toString());
        }
        return true;
    }
    private Bean<?> createBean() {
        return new Houzhenguo();
    }
}
