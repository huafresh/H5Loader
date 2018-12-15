package com.hua.h5loader_core;

import android.os.Parcel;
import android.support.annotation.DrawableRes;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/14 14:52
 */

public class BarParam extends KeyUrlParam {
    private int toolbarBacColor;
    @DrawableRes
    private int iconBack;
    private String title;
    private int titleColor;
    private int titleSize;

    public int getToolbarBacColor() {
        return toolbarBacColor;
    }

    public int getIconBack() {
        return iconBack;
    }

    public String getTitle() {
        return title;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public int getTitleSize() {
        return titleSize;
    }

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

    public static class Builder extends KeyUrlParam.Builder {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.toolbarBacColor);
        dest.writeInt(this.iconBack);
        dest.writeString(this.title);
        dest.writeInt(this.titleColor);
        dest.writeInt(this.titleSize);
    }

    public BarParam() {
    }

    protected BarParam(Parcel in) {
        super(in);
        this.toolbarBacColor = in.readInt();
        this.iconBack = in.readInt();
        this.title = in.readString();
        this.titleColor = in.readInt();
        this.titleSize = in.readInt();
    }

    public static final Creator<BarParam> CREATOR = new Creator<BarParam>() {
        @Override
        public BarParam createFromParcel(Parcel source) {
            return new BarParam(source);
        }

        @Override
        public BarParam[] newArray(int size) {
            return new BarParam[size];
        }
    };
}
