package cn.yong.demo.netty.util;

import cn.yong.demo.netty.domain.MsgDemo01;
import cn.yong.demo.netty.domain.MsgDemo02;
import cn.yong.demo.netty.domain.MsgDemo03;

/**
 * 消息工具类
 * @author Allen
 * @date 2022/10/25
 */
public class MsgUtil {

    public static MsgDemo01 buildMsgDemo01(String channelId, String msgContent) {
        return new MsgDemo01(channelId, msgContent);
    }

    public static MsgDemo02 buildMsgDemo02(String channelId, String msgContent) {
        return new MsgDemo02(channelId, msgContent);
    }

    public static MsgDemo03 buildMsgDemo03(String channelId, String msgContent) {
        return new MsgDemo03(channelId, msgContent);
    }

}
