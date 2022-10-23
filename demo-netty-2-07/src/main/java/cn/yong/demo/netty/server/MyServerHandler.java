package cn.yong.demo.netty.server;

import cn.yong.demo.netty.msg.Request;
import cn.yong.demo.netty.msg.Response;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * @author Allen
 * @date 2022/10/23
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object obj) throws Exception {
        Request msg = (Request) obj;
        // 反馈
        Response request = new Response();
        request.setRequestId(msg.getRequestId());
        System.out.println("接收请求：" + msg.getRequestId());
        request.setParam(msg.getResult() + " 请求成功，反馈结果请接受处理");
        ctx.writeAndFlush(request);

        ReferenceCountUtil.release(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
