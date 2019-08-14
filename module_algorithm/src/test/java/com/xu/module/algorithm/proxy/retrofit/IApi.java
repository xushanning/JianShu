package com.xu.module.algorithm.proxy.retrofit;

/**
 * @author 言吾許
 */
public interface IApi {
    @Deprecated
    void getData(int pageSize, int pageNum);

    @Deprecated
    void postEvent(String name);
}
