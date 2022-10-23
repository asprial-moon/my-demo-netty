package cn.yong.demo.netty.client;

import cn.yong.demo.netty.codec.RpcDecoder;
import cn.yong.demo.netty.codec.RpcEncoder;
import cn.yong.demo.netty.msg.Request;
import cn.yong.demo.netty.msg.Response;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author Line
 * @desc 客户端套接字
 * @date 2022/10/22
 */
public class ClientSocket implements Runnable {

    private ChannelFuture future;

    @Override
    public void run() {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.AUTO_READ, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new RpcDecoder(Response.class), new RpcEncoder(Request.class), new MyClientHandler());
                }
            });
            ChannelFuture future = b.connect("127.0.0.1", 7397).sync();
            this.future = future;
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    public ChannelFuture getFuture() {
        return future;
    }

    public void setFuture(ChannelFuture future) {
        this.future = future;
    }
}
