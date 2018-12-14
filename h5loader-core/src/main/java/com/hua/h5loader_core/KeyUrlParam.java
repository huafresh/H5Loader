package com.hua.h5loader_core;

import android.text.TextUtils;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/13 13:49
 */

public class KeyUrlParam {
    public String url;
    public String key;

    KeyUrlParam(Builder builder) {
        this.url = builder.url;
        this.key = builder.key;
    }

    public static Builder newKeyUrlParam() {
        return new Builder();
    }

    public static class Builder extends BaseBuilder {
        private String url;
        private String key;
        private int backgroundColor;
        private int iconBack;
        private String title;
        private int titleColor;
        private int titleSize;

        Builder() {
        }

        @Override
        public Object build() {
            return new KeyUrlParam(this);
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder key(String key) {
            this.key = key;
            return this;
        }

        public Builder backgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder iconBack(int iconBack) {
            this.iconBack = iconBack;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder titleColor(int titleColor) {
            this.titleColor = titleColor;
            return this;
        }

        public Builder titleSize(int titleSize) {
            this.titleSize = titleSize;
            return this;
        }
    }
}
