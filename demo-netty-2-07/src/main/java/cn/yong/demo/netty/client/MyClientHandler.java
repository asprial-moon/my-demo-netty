package cn.yong.demo.netty.client;

import cn.yong.demo.netty.msg.Response;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author Line
 * @desc
 * @date 2022/10/22
 */
public class MyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object obj) throws Exception {
        Response msg = (Response) obj;
        String requestId = msg.getRequestId();
        SyncWri
    }
}
