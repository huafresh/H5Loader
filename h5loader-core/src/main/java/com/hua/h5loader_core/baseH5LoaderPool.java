package com.hua.h5loader_core;

import android.util.LruCache;
import android.view.View;

/**
 * @author hua
 * @version 1.0
 * @date 2018/12/12
 */
abstract class baseH5LoaderPool implements IWebViewPool {

    private LruCache<String, IWebView> releaseLoaderCache;

    baseH5LoaderPool(int maxSize) {
        releaseLoaderCache = new LruCache<>(maxSize);
    }

    @Override
    public IWebView get(String key) {
        IWebView h5Loader = releaseLoaderCache.get(key);
        if (h5Loader == null) {
            h5Loader = createH5Loader(key);
        }
        return new H5LoaderWrap(key, h5Loader);
    }

    @Override
    public IWebView getNew(String key) {
        return new H5LoaderWrap(key, createH5Loader(key));
    }

    @Override
    public void release(IWebView h5Loader) {
        if (h5Loader instanceof H5LoaderWrap) {
            String key = ((H5LoaderWrap) h5Loader).key;
            IWebView loader = ((H5LoaderWrap) h5Loader).h5Loader;
            releaseLoaderCache.put(key, loader);
        }
    }

    protected abstract IWebView createH5Loader(String key);

    static class H5LoaderWrap implements IWebView {
        private final String key;
        private IWebView h5Loader;

        H5LoaderWrap(String key, IWebView h5Loader) {
            this.key = key;
            this.h5Loader = h5Loader;
        }

        @Override
        public void loadUrl(String url) {
            h5Loader.loadUrl(url);
        }

        @Override
        public View getWebView() {
            return h5Loader.getWebView();
        }

        @Override
        public void release() {
            h5Loader.release();
        }
    }
}
