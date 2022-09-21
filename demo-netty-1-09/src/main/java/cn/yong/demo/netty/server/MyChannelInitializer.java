package cn.yong.demo.netty.server;

import cn.yong.demo.netty.code.MyDecoder;
import cn.yong.demo.netty.code.MyEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;

/**
 * @author Line
 * @desc
 * @date 2022/9/20
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        // 基于换行符号
        channel.pipeline().addLast(new LineBasedFrameDecoder(1024));
        // 解码转String，注意调整自己的编码格式GBK、UTF-8
        channel.pipeline().addLast(new MyDecoder());
        // 编码转String，注意调整自己的编码格式GBK、UTF-8
        channel.pipeline().addLast(new MyEncoder());
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new MyServerHandler());
    }
}
