package cn.yong.demo.netty.server;

import cn.yong.demo.netty.codec.RpcDecoder;
import cn.yong.demo.netty.codec.RpcEncoder;
import cn.yong.demo.netty.msg.Request;
import cn.yong.demo.netty.msg.Response;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author Allen
 * @date 2022/10/23
 */
public class ServerSocket implements Runnable {
    private ChannelFuture future;

    @Override
    public void run() {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(
                                    new RpcDecoder(Request.class),
                                    new RpcEncoder(Response.class),
                                    new MyServerHandler()
                            );
                        }
                    });
            ChannelFuture future = null;
            future = b.bind(7397).sync();
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
