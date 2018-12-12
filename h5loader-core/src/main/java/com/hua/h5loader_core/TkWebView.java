package com.hua.h5loader_core;

import android.content.Context;
import android.util.AttributeSet;

import com.android.thinkive.framework.view.MyWebView;

/**
 * @author hua
 * @version 1.0
 * @date 2018/12/12
 */
public class TkWebView extends MyWebView implements IWebkit {
    public TkWebView(Context context) {
        super(context);
    }

    public TkWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TkWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public Object getWebkit() {
        return this;
    }
}
