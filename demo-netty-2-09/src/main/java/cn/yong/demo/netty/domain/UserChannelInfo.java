package cn.yong.demo.netty.domain;

import java.util.Date;

/**
 * 用户管道信息：记录某个用户分配到某个服务端
 * @author Allen
 * @date 2022/10/24
 */
public class UserChannelInfo {
    /**
     * 服务端：IP
     */
    private String ip;
    /**
     * 服务端：port
     */
    private int port;
    /**
     * channelId：通道ID
     */
    private String channelId;
    /**
     * 链接时间
     */
    private Date linkDate;

    public UserChannelInfo(String ip, int port, String channelId, Date linkDate) {
        this.ip = ip;
        this.port = port;
        this.channelId = channelId;
        this.linkDate = linkDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Date getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(Date linkDate) {
        this.linkDate = linkDate;
    }
}
