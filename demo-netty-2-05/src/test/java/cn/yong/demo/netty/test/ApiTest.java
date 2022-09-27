package cn.yong.demo.netty.test;

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
                            channel.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            channel.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));
                            channel.pipeline().addLast(new StringDecoder(Charset.forName("GBK")));
                            channel.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                                @Override
                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                    // 接收msg消息{与上一章节相比，此处已经不需要自己进行解码}
                                    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 客户端接收到消息：" + msg);
                                }
                            });
                        }
                    });
            ChannelFuture future = bootstrap.connect("127.0.0.1", 7397).sync();
            System.out.println("itstack-demo-netty client start done. {关注公众号：bugstack虫洞栈，获取源码}");

            //向服务端发送信息
            future.channel().writeAndFlush("你好，SpringBoot启动的netty服务端，我是https://bugstack.cn博主，付政委。这是我的公众号<bugstack虫洞栈>，关注我获取全套源码。“我的结尾是一个换行符，用于传输半包粘包处理”\r\n");
            future.channel().writeAndFlush("你好，SpringBoot启动的netty服务端，我是https://bugstack.cn博主，付政委。这是我的公众号<bugstack虫洞栈>，关注我获取全套源码。“我的结尾是一个换行符，用于传输半包粘包处理”\r\n");
            future.channel().writeAndFlush("你好，SpringBoot启动的netty服务端，我是https://bugstack.cn博主，付政委。这是我的公众号<bugstack虫洞栈>，关注我获取全套源码。“我的结尾是一个换行符，用于传输半包粘包处理”\r\n");
            future.channel().writeAndFlush("你好，SpringBoot启动的netty服务端，我是https://bugstack.cn博主，付政委。这是我的公众号<bugstack虫洞栈>，关注我获取全套源码。“我的结尾是一个换行符，用于传输半包粘包处理”\r\n");
            future.channel().writeAndFlush("你好，SpringBoot启动的netty服务端，我是https://bugstack.cn博主，付政委。这是我的公众号<bugstack虫洞栈>，关注我获取全套源码。“我的结尾是一个换行符，用于传输半包粘包处理”\r\n");

            future.channel().closeFuture().syncUninterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
        }
    }
}
