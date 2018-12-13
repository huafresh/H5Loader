package com.hua.h5loader_core;

import android.text.TextUtils;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/13 13:49
 */

public class H5Builder {
    private String url;
    private String key;
    private int type;
    private Object param;

    public H5Builder(String url) {
        this.url = url;
    }

    public H5LoadManager.H5Builder key(String key) {
        this.key = key;
        return this;
    }

    public H5LoadManager.H5Builder setWebContainerType(int type, Object param) {
        this.type = type;
        this.param = param;
        return this;
    }

    @SuppressWarnings("unchecked")
    public void load() {
        if (TextUtils.isEmpty(key)) {
            key = url;
        }

        IWebContainer webContainer = webContainers.get(type);
        if (webContainer == null) {
            throw new IllegalArgumentException("invalid web container type");
        }

        webContainer.load(param);
    }
}
