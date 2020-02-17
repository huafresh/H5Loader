package com.hua.h5loader_core;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;

import com.android.thinkive.framework.ThinkiveInitializer;
import com.android.thinkive.framework.WebViewManager;
import com.android.thinkive.framework.config.ConfigManager;
import com.android.thinkive.framework.view.MyWebView;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/13 9:09
 */

class TkWebViewPool implements IWebViewPool {
    private static int maxSize = 5;
    private LruCache<String, TkWebView> releasedCache;

    static {
        //String count = ConfigManager.getInstance().getSystemConfigValue("webviewCount");
//
//        if (!TextUtils.isEmpty(count)) {
//            maxSize = Integer.valueOf(count);
//        }
    }

    TkWebViewPool() {
        releasedCache = new LruCache<>(maxSize);
    }

    private TkWebView createWebView(Context context, String key) {
        MyWebView webView = null;
        if (context instanceof Activity) {
            webView = WebViewManager.getInstance().getNewWebView(context);
        } else {
            webView = WebViewManager.getInstance().getWebView(key);
        }
        return new TkWebView(webView);
    }

    @Override
    public TkWebView get(Context context, String key) {
        if (!TextUtils.isEmpty(key)) {
            TkWebView webView = releasedCache.get(key);
            if (webView == null) {
                webView = createWebView(context, key);
            }
            return new TkWebViewWrap(key, webView);
        } else {
            return createWebView(context, "");
        }

    }

    @Override
    public void release(TkWebView tkWebView) {
        if (tkWebView instanceof TkWebViewWrap) {
            String key = ((TkWebViewWrap) tkWebView).key;
            TkWebView webView = ((TkWebViewWrap) tkWebView).tkWebView;
            releasedCache.put(key, webView);
        }
    }

    static class TkWebViewWrap extends TkWebView {
        private final String key;
        private TkWebView tkWebView;

        TkWebViewWrap(String key, TkWebView tkWebView) {
            super(tkWebView.getMyWebView());
            this.key = key;
            this.tkWebView = tkWebView;
        }

        @Override
        public MyWebView getMyWebView() {
            return tkWebView.getMyWebView();
        }

        @Override
        public void release() {
            tkWebView.release();
        }
    }
}
