package cn.yong.demo.netty.client;

import cn.yong.demo.netty.codec.ObjDecoder;
import cn.yong.demo.netty.codec.ObjEncoder;
import cn.yong.demo.netty.domain.MsgInfo;
import cn.yong.demo.netty.domain.UserInfo;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author Line
 * @desc
 * @date 2022/9/25
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        // 对象传输处理
//        channel.pipeline().addLast(new ObjDecoder(MsgInfo.class));
//        channel.pipeline().addLast(new ObjEncoder(MsgInfo.class));
        channel.pipeline().addLast(new ObjDecoder(UserInfo.class));
        channel.pipeline().addLast(new ObjEncoder(UserInfo.class));
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new MyClientHandler());
    }
}
