package com.hua.h5loader_core;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/13 10:10
 */

public class CommWebFragment extends Fragment {
    protected static final String BUNDLE_KEY = "key";
    protected static final String BUNDLE_URL = "url";
    protected IWebContainer<?> h5UIContainer;
    private String key;
    private String url;
    private FrameLayout frameLayout;
    private IWebView webView;

    public static CommWebFragment newInstance(String key, String url) {
        Bundle args = new Bundle();
        args.putString(BUNDLE_KEY, key);
        args.putString(BUNDLE_URL, url);
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
        frameLayout = rootView.findViewById(R.id.fl_web_container);
        if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(key)) {
            webView = H5LoadManager.get().getWebViewPool().get(key);
            webView.loadUrl(url);
            frameLayout.addView(webView.getWebView());
        }
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        frameLayout.removeAllViews();
        webView.release();
    }

    static void addWebContainer(SparseArray<IWebContainer> output) {
        CommWebContainer webContainer = new CommWebContainer();
        output.put(webContainer.type(), webContainer);
    }

    static class CommWebContainer implements IWebContainer<H5Builder> {

        @Override
        public int type() {
            return H5LoadManager.h5_ui_container_type_comm;
        }

        @Override
        public H5Builder paramBuilder() {
            return null;
        }

        @Override
        public void load(H5Builder builder) {

        }
    }

    static class CommWebParam {
        String key;
        String url;
    }
}
