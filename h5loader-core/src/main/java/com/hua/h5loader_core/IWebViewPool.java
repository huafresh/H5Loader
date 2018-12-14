package com.hua.h5loader_core;

import android.content.Context;
import android.support.annotation.Nullable;

/**
 * @author hua
 * @version 1.0
 * @date 2018/12/12
 */
interface IWebViewPool {

    IWebView get(@Nullable Context context, String key);

    void release(IWebView webView);
}
