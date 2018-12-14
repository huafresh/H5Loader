package com.hua.h5loader_core;

import android.content.Context;

import java.util.HashMap;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/13 9:42
 */

public class H5LoadManager {
    public static final int h5_ui_container_type_comm = 0;
    public static final int h5_ui_container_type_bar = 1;
    public static final int h5_ui_container_type_progress = 2;
    private IWebViewPool loaderPool;
    private HashMap<Class, IWebPageType> webPageTypes;

    public static H5LoadManager get() {
        return Holder.S_INSTANCE;
    }


    private static final class Holder {
        private static final H5LoadManager S_INSTANCE = new H5LoadManager();
    }

    private H5LoadManager() {
        loaderPool = new TkWebViewPool();
        collectDefaultWebContainer();
    }

    private void collectDefaultWebContainer() {
        webPageTypes = new HashMap<>();
        CommWebFragment.addWebContainer(webPageTypes);
    }

    /**
     * @param builderType 这里的builderType是{@link IWebPageType#newParamBuilder()}返回的对象的类型.
     * @param <T>         builderType
     * @return param builder
     */
    @SuppressWarnings("unchecked")
    public <T extends BaseBuilder> T beginH5Load(Class<T> builderType) {
        IWebPageType webPageType = webPageTypes.get(builderType);
        if (webPageType == null) {
            throw new IllegalArgumentException("invalid " + builderType +
                    ". call registerWebPageType() method first");
        }

        return (T) webPageType.newParamBuilder();
    }

    @SuppressWarnings("unchecked")
    void load(Context context, BaseBuilder builder) {
        IWebPageType webContainer = webPageTypes.get(builder.getClass());
        if (webContainer != null) {
            webContainer.load(context, builder.build());
        }
    }

    /**
     * 自定义页面类型
     */
    public void registerWebPageType(IWebPageType webPageType) {

    }

    IWebViewPool getWebViewPool() {
        return loaderPool;
    }

    /**
     * 使用applicationContext获取WebView对象。
     *
     * @param key the key
     * @return IWebView
     */
    public IWebView getWebView(String key) {
        return this.getWebView(null, key);
    }

    /**
     * 根据key获取一个WebView对象，H5LoaderManager不会保存这里返回的对象。
     * <p>
     * 当WebView不使用时，可调用{@link IWebView#release()}标记该对象可复用，此时
     * H5LoaderManager会持久持有该对象。因此context传的是Activity时，建议不要调用。
     *
     * @param context Context
     * @param key     the key
     * @return IWebView
     */
    public IWebView getWebView(Context context, String key) {
        return loaderPool.get(context, key);
    }
}
