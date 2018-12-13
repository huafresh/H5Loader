package com.hua.h5loader_core;

import android.view.View;

/**
 * @author hua
 * @version 1.0
 * @date 2018/12/12
 */
public interface IWebView {

    void loadUrl(String url);

    View getWebView();

    void release();
}
