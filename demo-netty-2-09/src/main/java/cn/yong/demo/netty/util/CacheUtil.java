package cn.yong.demo.netty.util;

import cn.yong.demo.netty.server.NettyServer;
import io.netty.channel.Channel;
import org.apache.catalina.util.ServerInfo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 缓存工具
 * 缓存必要信息，用于业务处理流程
 * @author Allen
 * @date 2022/10/24
 */
public class CacheUtil {

    // 缓存channel
    public static Map<String, Channel> cacheChannel = Collections.synchronizedMap(new HashMap<>());

    // 缓存服务信息
    public static Map<Integer, ServerInfo> serverInfoMap = Collections.synchronizedMap(new HashMap<>());

    // 缓存服务端
    public static Map<Integer, NettyServer> serverMap = Collections.synchronizedMap(new HashMap<>());

}
