package cn.yong.demo.netty.domain;

/**
 * @author Line
 * @desc
 * @date 2022/9/23
 */
public interface MsgBodyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:org.itstack.demo.netty.domain.MsgBody)
    com.google.protobuf.MessageOrBuilder {

        /**
         * <code>string channelId = 1;</code>
         */
        java.lang.String getChannelId();
        /**
         * <code>string channelId = 1;</code>
         */
        com.google.protobuf.ByteString
        getChannelIdBytes();

        /**
         * <code>string msgInfo = 2;</code>
         */
        java.lang.String getMsgInfo();
        /**
         * <code>string msgInfo = 2;</code>
         */
        com.google.protobuf.ByteString
        getMsgInfoBytes();
}
