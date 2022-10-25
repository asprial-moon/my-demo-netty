package cn.yong.demo.netty.client;

import cn.yong.demo.netty.client.MyChannelInitializer;
import cn.yong.demo.netty.util.MsgUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Netty客户端
 * @author Allen
 * @date 2022/10/25
 */
public class NettyClient {

    public static void main(String[] args) {
        new NettyClient().connect("127.0.0.1", 7397);
    }

    private void connect(String inetHost, int initPort) {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.AUTO_READ, true);
            b.handler(new MyChannelInitializer());
            ChannelFuture f = b.connect(inetHost, initPort).sync();
            System.out.println("my-demo-netty client start done. {学学到死}");

            // 测试消息，分别发放demo01、demo02、demo03
            f.channel().writeAndFlush(MsgUtil.buildMsgDemo01(f.channel().id().toString(), "你好，消息体MsgDemo01，我是https://bugstack.cn博主，付政委。这是我的公众号<bugstack虫洞栈>，欢迎关注我获取案例源码。"));
            f.channel().writeAndFlush(MsgUtil.buildMsgDemo02(f.channel().id().toString(), "你好，消息体MsgDemo02，我是https://bugstack.cn博主，付政委。这是我的公众号<bugstack虫洞栈>，欢迎关注我获取案例源码。"));
            f.channel().writeAndFlush(MsgUtil.buildMsgDemo03(f.channel().id().toString(), "你好，消息体MsgDemo03，我是https://bugstack.cn博主，付政委。这是我的公众号<bugstack虫洞栈>，欢迎关注我获取案例源码。"));

            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
        }
    }



}
