package com.hua.h5loader_core;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
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
public class BarWebPage extends BaseWebPage<BarParam.Builder, BarParam> {

    static void add(SparseArray<IWebPageType> ids) {
        BarWebPage webPageType = new BarWebPage();
        ids.put(webPageType.id(), webPageType);
    }

    @Override
    public int id() {
        return H5LoadManager.WEB_PAGE_TYPE_BAR;
    }

    @Override
    public BarParam.Builder newBuilder() {
        return BarParam.newBuilder();
    }

    @Override
    public View onCreateView(Context context,
                             @NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             BarParam param) {
        View contentView = inflater.inflate(R.layout.fragment_bar_web, container, false);
        Toolbar toolbar = contentView.findViewById(R.id.tb_toolbar);
        FrameLayout webContainer = contentView.findViewById(R.id.fl_container);
        MyWebView webView = getWebView(param.getKey());
        if (!TextUtils.isEmpty(param.getUrl())) {
            webView.loadUrl(param.getUrl());
        }
        webContainer.addView(webView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        toolbar.setBackgroundColor(param.getToolbarBacColor());
        toolbar.setNavigationIcon(param.getIconBack());
        toolbar.setTitle(param.getTitle());
        toolbar.setTitleTextColor(param.getTitleColor());
        return contentView;
    }

}
