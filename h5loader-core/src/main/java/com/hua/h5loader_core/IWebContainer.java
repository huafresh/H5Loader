package com.hua.h5loader_core;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/13 10:04
 */

public interface IWebContainer<B> {
    int type();

    B paramBuilder();

    void load(B builder);
}
