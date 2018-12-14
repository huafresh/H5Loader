package com.hua.h5loader_core;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.LruCache;
import android.view.View;

/**
 * @author hua
 * @version 1.0
 * @date 2018/12/12
 */
abstract class BaseWebViewPool implements IWebViewPool {

    private LruCache<String, IWebView> releasedWebViewCache;

    BaseWebViewPool(int maxSize) {
        releasedWebViewCache = new LruCache<>(maxSize);
    }

    @Override
    public IWebView get(Context context, String key) {
        IWebView webView = releasedWebViewCache.get(key);
        if (webView == null) {
            webView = createWebView(context, key);
        }
        return new WebViewWrap(key, webView);
    }

    @Override
    public void release(IWebView iWebView) {
        if (iWebView instanceof WebViewWrap) {
            String key = ((WebViewWrap) iWebView).key;
            IWebView webView = ((WebViewWrap) iWebView).webView;
            releasedWebViewCache.put(key, webView);
        }
    }

    protected abstract IWebView createWebView(@Nullable Context context, String key);

    static class WebViewWrap implements IWebView {
        private final String key;
        private IWebView webView;

        WebViewWrap(String key, IWebView webView) {
            this.key = key;
            this.webView = webView;
        }

        @Override
        public void loadUrl(String url) {
            webView.loadUrl(url);
        }

        @Override
        public View getWebView() {
            return webView.getWebView();
        }

        @Override
        public void release() {
            webView.release();
        }
    }
}
