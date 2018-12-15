package com.hua.h5loader_core;

import android.content.Context;
import android.util.SparseArray;

import com.android.thinkive.framework.view.MyWebView;

import java.util.HashMap;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/13 9:42
 */

public class H5LoadManager {
    public static final int WEB_PAGE_TYPE_COMM = 0;
    public static final int WEB_PAGE_TYPE_BAR = 1;
    public static final int WEB_PAGE_TYPE_BAR_PROGRESS = 2;

    private IWebViewPool loaderPool;
    private SparseArray<IWebPageType> webPageTypeIds = new SparseArray<>();

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
        CommWebPage.add(webPageTypeIds);
        BarWebPage.add(webPageTypeIds);
    }

    IWebPageType getWebPageTypeById(int id) {
        return webPageTypeIds.get(id);
    }

    public KeyUrlParam.Builder openCommWeb() {
        return beginBuildParam(WEB_PAGE_TYPE_COMM, KeyUrlParam.Builder.class);
    }

    public BarParam.Builder openBarWeb() {
        return beginBuildParam(WEB_PAGE_TYPE_BAR, BarParam.Builder.class);
    }

    /**
     * @param builderType 这里的builderType是{@link IWebPageType#newBuilder()}
     *                    返回的对象的类型.
     * @param <T>         builderType
     * @return param builder
     */
    @SuppressWarnings("unchecked")
    public <T extends BaseBuilder> T beginBuildParam(int webType, Class<T> builderType) {
        IWebPageType webPageType = webPageTypeIds.get(webType);
        if (webPageType == null) {
            throw new IllegalArgumentException("invalid " + builderType +
                    ". call registerWebPageType() method first");
        }
        T t = (T) webPageType.newBuilder();
        t.webType = webType;
        return t;
    }

    @SuppressWarnings("unchecked")
    void load(Context context, BaseParam param) {
        IWebPageType webPageType = webPageTypeIds.get(param.getWebType());
        if (webPageType != null) {
            CommWebActivity.startWebPage(context, param);
        }
    }

    /**
     * 自定义页面类型
     */
    public void registerWebPageType(IWebPageType webPageType) {
        webPageTypeIds.put(webPageType.id(), webPageType);
    }

    IWebViewPool getWebViewPool() {
        return loaderPool;
    }

    public TkWebView getWebView() {
        return this.getWebView(null, null);
    }

    /**
     * 使用applicationContext获取WebView对象。
     *
     * @param key the key
     * @return IWebView
     */
    public TkWebView getWebView(String key) {
        return this.getWebView(null, key);
    }

    /**
     * 根据key获取一个WebView对象，H5LoaderManager不会保存这里返回的对象。
     * <p>
     * 当WebView不使用时，可调用{@link TkWebView#release()}标记该对象可复用，此时
     * H5LoaderManager会持久持有该对象，以便下次复用。
     * 因此如果context传的是Activity时，建议不要调用。
     *
     * @param context Context
     * @param key     the key
     * @return IWebView
     */
    public TkWebView getWebView(Context context, String key) {
        return loaderPool.get(context, key);
    }
}
