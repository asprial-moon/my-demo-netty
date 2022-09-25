package cn.yong.demo.netty.util;

import cn.yong.demo.netty.domain.MsgInfo;

/**
 * @author Line
 * @desc
 * @date 2022/9/23
 */
public class MsgUtil {

    public static MsgInfo buildMsg(String channelId, String msgContent) {
        return new MsgInfo(channelId, msgContent);
    }
}
