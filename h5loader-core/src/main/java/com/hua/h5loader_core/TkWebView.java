package com.hua.h5loader_core;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.android.thinkive.framework.view.MyWebView;

/**
 * @author hua
 * @version 1.0
 * @date 2018/12/12
 */
class TkWebView implements IWebView {
    private MyWebView myWebView;

    TkWebView(MyWebView myWebView) {
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
        ViewParent parent = myWebView.getParent();
        if (parent != null && parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(myWebView);
        }
        H5LoadManager.get().getWebViewPool().release(this);
    }
}
