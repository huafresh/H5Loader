package com.hua.h5loader_core;

import android.content.Context;
import android.util.AttributeSet;

import com.android.thinkive.framework.WebViewManager;
import com.android.thinkive.framework.view.MyWebView;

/**
 * @author hua
 * @version 1.0
 * @date 2018/12/15
 */
public class TkWebView {

    private MyWebView myWebView;

    TkWebView(MyWebView myWebView) {
        this.myWebView = myWebView;
    }

    public MyWebView getMyWebView(){
        return myWebView;
    }

    public void release() {
        H5LoadManager.get().getWebViewPool().release(this);
        WebViewManager.getInstance().releaseWebView(myWebView);
    }
}
