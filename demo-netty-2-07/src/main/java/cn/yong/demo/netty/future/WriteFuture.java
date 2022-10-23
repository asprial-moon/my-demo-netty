package cn.yong.demo.netty.future;

import cn.yong.demo.netty.msg.Response;

import java.util.concurrent.Future;

/**
 * @author Line
 * @desc 写入
 * @date 2022/10/22
 */
public interface WriteFuture<T> extends Future<T> {

    Throwable cause();

    void setCause(Throwable cause);

    boolean isWriteSuccess();

    void setWriteResult(boolean result);

    String requestId();

    T response();

    void setResponse(Response response);

    boolean isTimeout();
}
