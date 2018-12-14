package com.hua.h5loader_core;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.HashMap;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/13 10:10
 */

public class CommWebFragment extends Fragment {
    protected static final String BUNDLE_KEY = "key";
    protected static final String BUNDLE_URL = "url";
    protected String key;
    protected String url;
    private FrameLayout frameLayout;
    protected IWebView webView;

    public static CommWebFragment newInstance(KeyUrlParam param) {
        Bundle args = new Bundle();
        args.putString(BUNDLE_KEY, param.key);
        args.putString(BUNDLE_URL, param.url);
        CommWebFragment fragment = new CommWebFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle args = getArguments();
        if (args != null) {
            key = args.getString(BUNDLE_KEY);
            url = args.getString(BUNDLE_URL);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_h5_comm, container, false);
        frameLayout = rootView.findViewById(R.id.fl_content_container);

        if (!TextUtils.isEmpty(key)) {
            webView = H5LoadManager.get().getWebView(key);
        }

        View contentView = createContentView(inflater, frameLayout);
        if (contentView != null) {
            frameLayout.addView(contentView);
        }
        return rootView;
    }

    protected @Nullable
    View createContentView(LayoutInflater inflater, ViewGroup parent) {
        return webView != null ? webView.getWebView() : null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Looper.getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                @Override
                public boolean queueIdle() {
                    loadUrl();
                    return false;
                }
            });
        } else {
            loadUrl();
        }
    }

    private void loadUrl() {
        if (webView != null && !TextUtils.isEmpty(url)) {
            webView.loadUrl(url);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        frameLayout.removeAllViews();
        webView.release();
    }

    static void addWebContainer(HashMap<Class, IWebPageType> output) {
        CommWebPageType webContainer = new CommWebPageType();
        output.put(webContainer.newParamBuilder().getClass(), webContainer);
    }

    static class CommWebPageType implements IWebPageType<KeyUrlParam.Builder, KeyUrlParam> {

        @Override
        public KeyUrlParam.Builder newParamBuilder() {
            return KeyUrlParam.newBuilder();
        }

        @Override
        public void load(Context context, KeyUrlParam param) {
            CommWebActivity.start(context, CommWebFragment.newInstance(param));
        }
    }
}
