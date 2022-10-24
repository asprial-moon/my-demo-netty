package cn.yong.demo.netty.util;

import cn.yong.demo.netty.domain.MsgAgreement;
import com.alibaba.fastjson.JSON;

/**
 * 消息工具类
 * @author Allen
 * @date 2022/10/24
 */
public class MsgUtil {

    public static MsgAgreement buildMsg(String channelId, String content) {
        return new MsgAgreement(channelId, content);
    }

    public static MsgAgreement json2Obj(String objJsonStr) {
        return JSON.parseObject(objJsonStr, MsgAgreement.class);
    }

    public static String obj2Json(MsgAgreement msgAgreement) {
        return JSON.toJSONString(msgAgreement + "\r\n");
    }

}
