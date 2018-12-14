package com.hua.h5loader_core;

import android.view.View;

/**
 * WebView抽象。具体实现可能是android系统的WebView，也可能是x5WebView。
 *
 * @author hua
 * @version 1.0
 * @date 2018/12/12
 */
public interface IWebView {

    void loadUrl(String url);

    View getWebView();

    void release();
}
