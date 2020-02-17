package com.hua.h5loader_core;

import android.content.Context;

import androidx.annotation.Nullable;

import com.android.thinkive.framework.view.MyWebView;

/**
 * @author hua
 * @version 1.0
 * @date 2018/12/15
 */
public abstract class BaseWebPage<B extends BaseBuilder, P extends BaseParam>
        implements IWebPageType<B, P> {
    protected IWebHost host;
    private TkWebView tkWebView;

    protected void finish() {
        if (host != null) {
            host.finish();
        }
    }

    protected @Nullable
    Context getContext() {
        if (host != null) {
            return host.getContext();
        }
        return null;
    }

    protected MyWebView getWebView(String key) {
        if (tkWebView == null) {
            tkWebView = H5LoadManager.get().getWebView(key);
        }
        return tkWebView.getMyWebView();
    }

    @Override
    public void onAttachToHost(IWebHost host) {
        this.host = host;
    }

    @Override
    public void onDetachFromHost() {
        this.host = null;
    }

    @Override
    public void onDestroyView() {
        if (tkWebView != null) {
            tkWebView.release();
        }
    }
}
