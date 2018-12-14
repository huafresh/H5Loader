package com.hua.h5loader_core;

import android.support.annotation.DrawableRes;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/14 14:52
 */

public class BarParam extends KeyUrlParam{
    public int backgroundColor;
    @DrawableRes
    public int iconBack;
    public String title;
    public int titleColor;
    public int titleSize;

    private BarParam(Builder builder) {
        super(builder);
        this.backgroundColor = builder.backgroundColor;
        this.iconBack = builder.iconBack;
        this.title = builder.title;
        this.titleColor = builder.titleColor;
        this.titleSize = builder.titleSize;
    }

    public static Builder newBarParam() {
        return new Builder();
    }


    public static final class Builder extends KeyUrlParam.Builder{
        private int backgroundColor;
        private int iconBack;
        private String title;
        private int titleColor;
        private int titleSize;

        private Builder() {
        }

        public BarParam build() {
            return new BarParam(this);
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
