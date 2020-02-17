package com.hua.h5loader;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hua.h5loader_core.BaseWebPage;

/**
 * @author hua
 * @version 1.0
 * @date 2018/12/15
 */
public class ProgressWebPage extends BaseWebPage<ProgressParam.Builder, ProgressParam> {
    public static final int WEB_TYPE_PROGRESS = 3;

    @Override
    public int id() {
        return WEB_TYPE_PROGRESS;
    }

    @Override
    public ProgressParam.Builder newBuilder() {
        return ProgressParam.builder();
    }

    @Override
    public View onCreateView(Context context,
                             @NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, ProgressParam param) {
        //这里编写带进度条样式的页面视图。
        //webView可以通过#getWebView()方法获取。
        //H5LoaderManager会在需要时调用此方法获取View，实现时不要对view做缓存
        //因为H5LoaderManager会持久持有这个对象。
        return null;
    }

}
