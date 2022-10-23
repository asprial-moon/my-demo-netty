package cn.yong.demo.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Line
 * @desc 客户端处理器
 * @date 2022/10/22
 */
public class MyClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * 当客户端主动链接服务端的链接后，这个通过就是活跃的了。也就是客户端与服务端建立了通信通道并且可以传输数据
     * @param ctx 通道处理程序上下文
     * @throws Exception 抛出异常信息
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel) ctx.channel();
        System.out.println("链接报告开始");
        System.out.println("链接报告信息：本客户端链接到服务端。channelId：" + channel.id());
        System.out.println("链接报告IP:" + channel.localAddress().getHostString());
        System.out.println("链接报告Port:" + channel.localAddress().getPort());
        System.out.println("链接报告完毕");
    }

    /**
     * 客户端主动端口服务端的链接后，这个通道就是不活跃的。也就是说客户端与服务端的关闭了通信通道并且不可以传输数据
     * @param ctx 通道处理程序上下文
     * @throws Exception 异常
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("断开链接重连" + ctx.channel().localAddress().toString());
        // 使用过程中断线重连
        new Thread(() -> {
            try {
                new NettyClient().connect("127.0.0.1", 7397);
                System.out.println("netty client start done.");
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("netty client start error on reconnect...");
            }
        }).start();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 接收msg消息{与上一章相比，此处已经不需要自己进行解码了}
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息：" + msg);
    }

    /**
     * 抓住异常，当发生异常的时候，可以做一些相应的处理，比如打印日志、关闭连接
     * @param ctx 通道处理程序上下文
     * @param cause 异常
     * @throws Exception 抛出异常信息
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("异常信息，断开重连：\r\n" + cause.getMessage());
        ctx.close();
    }
}
