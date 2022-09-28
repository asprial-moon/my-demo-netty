package cn.yong.demo.netty.test;

import cn.yong.demo.netty.codec.ObjDecoder;
import cn.yong.demo.netty.codec.ObjEncoder;
import cn.yong.demo.netty.domain.TransportProtocol;
import cn.yong.demo.netty.domain.User;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Line
 * @desc
 * @date 2022/9/20
 */
public class ApiTest {

    public static void main(String[] args) {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.AUTO_READ, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                           channel.pipeline().addLast(new ObjDecoder(TransportProtocol.class));
                           channel.pipeline().addLast(new ObjEncoder(TransportProtocol.class));
                           channel.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                               @Override
                               public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

                               }
                           });
                        }
                    });
            ChannelFuture future = bootstrap.connect("127.0.0.1", 7397).sync();
            System.out.println("itstack-demo-netty client start done. {关注公众号：bugstack虫洞栈，获取源码}");

            //向服务端发送信息
            TransportProtocol tp1 = new TransportProtocol(1, new User(UUID.randomUUID().toString(), "李小明", 1, "T0-1", new Date(), "13566668888", "184172133@qq.com", "北京"));
            TransportProtocol tp2 = new TransportProtocol(1, new User(UUID.randomUUID().toString(), "张大明", 2, "T0-2", new Date(), "13566660001", "huahua@qq.com", "南京"));
            TransportProtocol tp3 = new TransportProtocol(1, new User(UUID.randomUUID().toString(), "李书鹏", 2, "T1-1", new Date(), "13566660002", "xiaobai@qq.com", "榆树"));
            TransportProtocol tp4 = new TransportProtocol(1, new User(UUID.randomUUID().toString(), "韩小雪", 2, "T2-1", new Date(), "13566660002", "xiaobai@qq.com", "榆树"));
            TransportProtocol tp5 = new TransportProtocol(1, new User(UUID.randomUUID().toString(), "董叔飞", 2, "T4-1", new Date(), "13566660002", "xiaobai@qq.com", "河北"));
            TransportProtocol tp6 = new TransportProtocol(1, new User(UUID.randomUUID().toString(), "候明相", 2, "T5-1", new Date(), "13566660002", "xiaobai@qq.com", "下花园"));
            TransportProtocol tp7 = new TransportProtocol(1, new User(UUID.randomUUID().toString(), "田明明", 2, "T3-1", new Date(), "13566660002", "xiaobai@qq.com", "东平"));
            TransportProtocol tp8 = new TransportProtocol(1, new User(UUID.randomUUID().toString(), "王大伟", 2, "T4-1", new Date(), "13566660002", "xiaobai@qq.com", "西湖"));
            TransportProtocol tp9 = new TransportProtocol(1, new User(UUID.randomUUID().toString(), "李雪明", 2, "T1-1", new Date(), "13566660002", "xiaobai@qq.com", "南昌"));
            TransportProtocol tp10 = new TransportProtocol(1, new User(UUID.randomUUID().toString(), "朱小飞", 2, "T2-1", new Date(), "13566660002", "xiaobai@qq.com", "吉林"));
            TransportProtocol tp11 = new TransportProtocol(1, new User(UUID.randomUUID().toString(), "牛大明", 2, "T1-1", new Date(), "13566660002", "xiaobai@qq.com", "长春"));
            TransportProtocol tp12 = new TransportProtocol(1, new User(UUID.randomUUID().toString(), "关雪儿", 2, "T2-1", new Date(), "13566660002", "xiaobai@qq.com", "深圳"));

            //向服务端发送信息
            future.channel().writeAndFlush(tp1);
            future.channel().writeAndFlush(tp2);
            future.channel().writeAndFlush(tp3);
            future.channel().writeAndFlush(tp4);
            future.channel().writeAndFlush(tp5);
            future.channel().writeAndFlush(tp6);
            future.channel().writeAndFlush(tp7);
            future.channel().writeAndFlush(tp8);
            future.channel().writeAndFlush(tp9);
            future.channel().writeAndFlush(tp10);
            future.channel().writeAndFlush(tp11);
            future.channel().writeAndFlush(tp12);

            future.channel().closeFuture().syncUninterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
        }
    }
}
