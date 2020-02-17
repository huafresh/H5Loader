package com.hua.h5loader_core;

import android.content.Context;
import androidx.annotation.Nullable;

/**
 * @author hua
 * @version 1.0
 * @date 2018/12/12
 */
interface IWebViewPool {

    TkWebView get(@Nullable Context context, String key);

    void release(TkWebView webView);
}
