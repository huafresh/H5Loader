package com.hua.h5loader_core;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;

import com.android.thinkive.framework.WebViewManager;
import com.android.thinkive.framework.config.ConfigManager;
import com.android.thinkive.framework.view.MyWebView;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/13 9:09
 */

class TkWebViewPool extends BaseWebViewPool {
    private static int maxSize = 5;

    static {
        String count = ConfigManager.getInstance().getSystemConfigValue("webviewCount");
        if (!TextUtils.isEmpty(count)) {
            maxSize = Integer.valueOf(count);
        }
    }

    TkWebViewPool() {
        super(maxSize);
    }

    @Override
    protected IWebView createWebView(Context context, String key) {
        MyWebView webView = null;
        if (context instanceof Activity) {
            webView = WebViewManager.getInstance().getNewWebView(context);
        } else {
            webView = WebViewManager.getInstance().getWebView(key);
        }
        return new TkWebView(webView);
    }

}
