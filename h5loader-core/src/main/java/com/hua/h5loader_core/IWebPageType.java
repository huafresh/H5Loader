package com.hua.h5loader_core;

import android.content.Context;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/13 10:04
 */

public interface IWebPageType<B extends BaseBuilder, P> {
    /**
     * 不同的页面类型可能需要不同的参数。
     * 比如带标题栏的页面需要传标题，等等。
     * 这里返回的就是这些参数的构造器。
     *
     * @return 参数构造器。
     */
    B newParamBuilder();

    /**
     * 当外界链式调用完毕最后调用load后，
     * H5LoaderManager会调用{@link BaseBuilder#createParam()}方法生成页面特定的参数对象.
     * 自定义页面需要使用这些参数把h5加载出来。
     * 如果UI调整不是很大，可以参考H5LoaderManager提供的默认实现，
     * 如：{@link CommWebFragment.CommWebPageType}
     * <p>
     * 自定义的页面类型可以自己new webView对象，不过强烈建议使用{@link H5LoadManager#getWebView}
     * 获取IWebView对象，以便使用缓存功能。
     *
     * @param context context, can be use to start activity.
     * @param param   current web page type specific param.
     */
    void load(Context context, P param);
}
