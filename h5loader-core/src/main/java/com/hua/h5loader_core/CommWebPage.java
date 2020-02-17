package com.hua.h5loader_core;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.android.thinkive.framework.view.MyWebView;

/**
 * @author hua
 * @version 1.0
 * @date 2018/12/15
 */
public class CommWebPage extends BaseWebPage<KeyUrlParam.Builder, KeyUrlParam> {

    static void add(SparseArray<IWebPageType> ids) {
        CommWebPage webPageType = new CommWebPage();
        ids.put(webPageType.id(), webPageType);
    }

    @Override
    public int id() {
        return H5LoadManager.WEB_PAGE_TYPE_COMM;
    }

    @Override
    public KeyUrlParam.Builder newBuilder() {
        return KeyUrlParam.newBuilder();
    }

    @Override
    public View onCreateView(Context context,
                                    @NonNull LayoutInflater inflater,
                                    @Nullable ViewGroup container,
                                    KeyUrlParam param) {
        FrameLayout contentView = new FrameLayout(context);
        MyWebView webView = getWebView(param.getKey());
        if (!TextUtils.isEmpty(param.getUrl())) {
            webView.loadUrl(param.getUrl());
        }
        contentView.addView(webView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        return contentView;
    }

}
