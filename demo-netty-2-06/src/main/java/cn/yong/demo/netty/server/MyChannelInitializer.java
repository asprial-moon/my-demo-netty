package cn.yong.demo.netty.server;

import cn.yong.demo.netty.codec.ObjDecoder;
import cn.yong.demo.netty.codec.ObjEncoder;
import cn.yong.demo.netty.domain.TransportProtocol;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Line
 * @desc
 * @date 2022/9/20
 */
@Service("myChannelInitializer")
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Autowired
    private MyServerHandler myServerHandler;

    @Override
    protected void initChannel(SocketChannel channel) {
        // 对象处理方法
        channel.pipeline().addLast(new ObjDecoder(TransportProtocol.class));
        channel.pipeline().addLast(new ObjEncoder(TransportProtocol.class));

        // 在管道中添加我们我们自己的接收数据实现方法
        channel.pipeline().addLast(myServerHandler);
    }
}
