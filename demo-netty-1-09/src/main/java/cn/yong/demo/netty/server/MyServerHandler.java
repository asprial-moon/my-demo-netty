package cn.yong.demo.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Line
 * @desc
 * @date 2022/9/20
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 当客户端主动连接服务器链接后，这个通道是活跃的了。也就是客户端与服务端建立了通信通道并且可以传输数据
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 日志信息
        SocketChannel channel = (SocketChannel) ctx.channel();
        System.out.println("链接报告开始 {公众号：bugstack虫洞栈 >获取学习源码}");
        System.out.println("链接报告信息：有一客户端链接到本服务端");
        System.out.println("链接报告IP:" + channel.localAddress().getHostString());
        System.out.println("链接报告Port:" + channel.localAddress().getPort());
        System.out.println("链接报告完毕");
    }

//    @Override
//    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("客户端断开链接" + ctx.channel().localAddress().toString());
//        // 当有客户端退出后，从channelGroup中移除
//        ChannelHandler.channelGroup.remove(ctx.channel());
//    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //接收msg消息{与上一章节相比，此处已经不需要自己进行解码}
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息：" + msg);
        // 通知客户端链消息发送成功
        ctx.writeAndFlush("hi I'm ok");
    }
//
//    /**
//     * 抓住异常，当发生异常的时候，可以做一些相应的处理，比如打印日志、关闭链接
//     * @param ctx
//     * @param cause
//     * @throws Exception
//     */
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        ctx.close();
//        System.out.println("异常信息：\r\n" + cause.getMessage());
//    }
}
