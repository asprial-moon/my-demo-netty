package cn.yong.demo.netty.util;

import cn.yong.demo.netty.domain.ServerMsgProtocol;
import com.alibaba.fastjson.JSON;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * @author Line
 * @desc 消息传输协议
 * @date 2022/9/23
 */
public class MsgUtil {

   public static TextWebSocketFrame buildMsgAll(String channelId, String msgInfo) {
       // 模拟头像
       int i = Math.abs(channelId.hashCode()) % 10;

       ServerMsgProtocol msg = new ServerMsgProtocol();
       // 链接信息：1自发信息、2群发信息
       msg.setType(2);
       msg.setChannelId(channelId);
       msg.setUserHeadImg("head" + i + ".jpg");
       msg.setMsgInfo(msgInfo);

       return new TextWebSocketFrame(JSON.toJSONString(msg));
   }

   public static TextWebSocketFrame buildMsgOwner(String channelId) {
       ServerMsgProtocol msg = new ServerMsgProtocol();
       // 链接信息；1连接信息、2消息信息
       msg.setType(1);
       msg.setChannelId(channelId);
       return new TextWebSocketFrame(JSON.toJSONString(msg));
   }
}
