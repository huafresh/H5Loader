package com.hua.h5loader_core;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/13 10:14
 */

public class BarWebFragment extends CommWebFragment {

    private Toolbar toolbar;
    private static final String KEY_BAC_COLOR = "bac_color";
    private static final String KEY_ICON_ID = "icon_id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_TITLE_COLOR = "title_color";
    private static final String KEY_TITLE_SIZE = "title_size";
    private int bacColor;
    private int iconId;
    private String title;
    private int titleColor;
    private int titleSize;

    public static BarWebFragment newInstance(
            String key,
            String url,
            int backgroundColor,
            @DrawableRes int iconBack,
            String title,
            int titleColor,
            int titleSize                ) {
        Bundle args = new Bundle();
        args.putString(BUNDLE_KEY, key);
        args.putString(BUNDLE_URL, url);
        args.putInt(KEY_BAC_COLOR, backgroundColor);
        args.putInt(KEY_ICON_ID, iconBack);
        args.putString(KEY_TITLE, title);
        args.putInt(KEY_TITLE_COLOR, titleColor);
        args.putInt(KEY_TITLE_SIZE, titleSize);
        BarWebFragment fragment = new BarWebFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle args = getArguments();
        if (args != null) {
            bacColor = args.getInt(KEY_BAC_COLOR);
            iconId = args.getInt(KEY_ICON_ID);
            title = args.getString(KEY_TITLE);
            titleColor = args.getInt(KEY_TITLE_COLOR);
            titleSize = args.getInt(KEY_TITLE_SIZE);
        }
    }

    @Nullable
    @Override
    protected View createContentView(LayoutInflater inflater, ViewGroup parent) {
        View contentView = inflater.inflate(R.layout.fragment_bar_web, parent, false);
        toolbar = contentView.findViewById(R.id.tb_toolbar);
        FrameLayout webContainer = contentView.findViewById(R.id.fl_container);
        if (webView != null) {
            webContainer.addView(webView.getWebView());
        }
        toolbar.setBackgroundColor(bacColor);
        toolbar.setNavigationIcon(iconId);
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(titleColor);
        return contentView;
    }
}
