package cn.yong.demo.netty.future;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Line
 * @desc 同步写入映射
 * @date 2022/10/22
 */
public class SyncWriteMap {
    public static Map<String, WriteFuture> syncKey = new ConcurrentHashMap<>();
}
