package com.hua.h5loader_core;

/**
 * @author hua
 * @version 1.0
 * @date 2018/12/12
 */
interface IWebViewPool {

    IWebView get(String key);

    IWebView getNew(String key);

    void release(IWebView loader);
}
