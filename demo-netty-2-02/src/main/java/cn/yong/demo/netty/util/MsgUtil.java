package cn.yong.demo.netty.util;

import cn.yong.demo.netty.domain.MsgBody;

/**
 * @author Line
 * @desc
 * @date 2022/9/23
 */
public class MsgUtil {

    public static MsgBody buildMsg(String channelId, String msgInfo) {
        MsgBody.Builder msg = MsgBody.newBuilder();
        msg.setChannelId(channelId);
        msg.setMsgInfo(msgInfo);
        return msg.build();
    }

}
