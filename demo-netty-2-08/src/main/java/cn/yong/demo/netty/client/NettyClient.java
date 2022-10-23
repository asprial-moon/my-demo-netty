package cn.yong.demo.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Netty 客户端
 * @author Allen
 * @date 2022/10/23
 */
public class NettyClient {

    public static void main(String[] args) {
        new NettyClient().connect("127.0.0.1", 7397);
    }

    public void connect(String inetHost, int inetPort) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.AUTO_READ, true);
            b.handler(new MyChannelInitializer());
            ChannelFuture future = b.connect(inetHost, inetPort).sync();
            future.addListener(new MyChannelFutureListener()); // 添加监听、处理重连
            future.channel().closeFuture().sync();
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
