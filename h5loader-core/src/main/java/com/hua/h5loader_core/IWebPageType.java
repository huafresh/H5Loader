package com.hua.h5loader_core;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/13 10:04
 */

public interface IWebPageType<B extends BaseBuilder, P extends BaseParam> {
    /**
     * identify this web page type.
     *
     * @return id
     */
    int id();

    /**
     * 不同的页面类型可能需要不同的参数。
     * 比如带标题栏的页面需要传标题，等等。
     * 这里返回的就是这些参数的构造器。
     *
     * @return builder type
     */
    B newBuilder();

    /**
     * 使用给定的参数和WebView生成页面特定的视图。
     * 这个视图会在Activity或者Fragment中显示。
     *
     * @param context   Context
     * @param inflater  LayoutInflater
     * @param container parent
     * @param param     page param
     * @return content view
     */
    View onCreateView(Context context,
                      @NonNull LayoutInflater inflater,
                      @Nullable ViewGroup container,
                      P param);

    /**
     * Activity或者Fragment销毁时调用。
     */
    void onDestroyView();

    /**
     * called before {@link #onCreateView}
     *
     * @param host IWebHost
     */
    void onAttachToHost(IWebHost host);

    /**
     * called after {@link #onDestroyView()}
     */
    void onDetachFromHost();
}
