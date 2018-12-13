package com.hua.h5loader_core;

import android.view.View;

import com.android.thinkive.framework.view.MyWebView;

/**
 * @author hua
 * @version 1.0
 * @date 2018/12/12
 */
public class TkWebView implements IWebView {
    private MyWebView myWebView;

    public TkWebView(MyWebView myWebView) {
        this.myWebView = myWebView;
    }

    @Override
    public void loadUrl(String url) {
        myWebView.loadUrl(url);
    }

    @Override
    public View getWebView() {
        return myWebView;
    }

    @Override
    public void release() {

    }
}
