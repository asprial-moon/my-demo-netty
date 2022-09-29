package cn.yong.demo.netty.domain;

/**
 * @author Line
 * @desc
 * @date 2022/9/28
 */
public class TransportProtocol {
    /**
     * 1用户信息
     */
    private Integer type;
    /**
     * 传输对象
     */
    private Object obj;

    public TransportProtocol() {}

    public TransportProtocol(Integer type, Object obj) {
        this.type = type;
        this.obj = obj;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
