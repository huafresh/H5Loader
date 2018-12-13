package com.hua.h5loader_core;

import android.text.TextUtils;

import com.android.thinkive.framework.WebViewManager;
import com.android.thinkive.framework.config.ConfigManager;
import com.android.thinkive.framework.view.MyWebView;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/13 9:09
 */

class TkH5LoaderPool extends baseH5LoaderPool {
    private static int maxSize = 5;

    static {
        String count = ConfigManager.getInstance().getSystemConfigValue("webviewCount");
        if (!TextUtils.isEmpty(count)) {
            maxSize = Integer.valueOf(count);
        }
    }

    TkH5LoaderPool() {
        super(maxSize);
    }

    @Override
    protected IWebView createH5Loader(String key) {
        MyWebView webView = WebViewManager.getInstance().getWebView(key);
        return new TkWebView(webView);
    }


}
