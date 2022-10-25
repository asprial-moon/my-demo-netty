package cn.yong.demo.netty.server;

import cn.yong.demo.netty.codec.ObjDecoder;
import cn.yong.demo.netty.codec.ObjEncoder;
import cn.yong.demo.netty.server.handler.MsgDemo01Handler;
import cn.yong.demo.netty.server.handler.MsgDemo02Handler;
import cn.yong.demo.netty.server.handler.MsgDemo03Handler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * 通道通信初始化
 * @author Allen
 * @date 2022/10/25
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        // 对象传输处理[解码]
        channel.pipeline().addLast(new ObjDecoder());
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new MsgDemo01Handler());
        channel.pipeline().addLast(new MsgDemo02Handler());
        channel.pipeline().addLast(new MsgDemo03Handler());
        // 对象传输处理[编码]
        channel.pipeline().addLast(new ObjEncoder());
    }
}
