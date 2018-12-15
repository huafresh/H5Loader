package com.hua.h5loader_core;

import android.support.annotation.DrawableRes;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/14 14:52
 */

public class BarParam extends KeyUrlParam {
    public int toolbarBacColor;
    @DrawableRes
    public int iconBack;
    public String title;
    public int titleColor;
    public int titleSize;

    @Override
    public void fill(BaseBuilder builder) {
        super.fill(builder);
        if (builder instanceof Builder) {
            this.toolbarBacColor = ((Builder) builder).toolbarBacColor;
            this.iconBack = ((Builder) builder).iconBack;
            this.title = ((Builder) builder).title;
            this.titleColor = ((Builder) builder).titleColor;
            this.titleSize = ((Builder) builder).titleSize;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder extends KeyUrlParam.Builder {
        private int toolbarBacColor;
        private int iconBack;
        private String title;
        private int titleColor;
        private int titleSize;

        @Override
        public BarParam createParam() {
            BarParam barParam = new BarParam();
            barParam.fill(this);
            return barParam;
        }

        public Builder toolbarBacColor(int backgroundColor) {
            this.toolbarBacColor = backgroundColor;
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
