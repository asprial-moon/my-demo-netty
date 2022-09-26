package cn.yong.demo.netty.util;

import cn.yong.demo.netty.domain.FileBurstInstruct;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Allen
 * @date 2022/9/26
 */
public class CacheUtil {
    public static Map<String, FileBurstInstruct> burstDataMap = new ConcurrentHashMap<>();
}
