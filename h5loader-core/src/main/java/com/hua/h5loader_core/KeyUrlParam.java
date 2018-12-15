package com.hua.h5loader_core;

import android.os.Parcel;
import android.text.TextUtils;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/13 13:49
 */

public class KeyUrlParam extends BaseParam{
    private String url;
    private String key;

    public static Builder newBuilder(){
        return new Builder();
    }

    public String getUrl() {
        return url;
    }

    public String getKey() {
        return key;
    }

    @Override
    public void fill(BaseBuilder builder) {
        if (builder instanceof Builder) {
            this.key = ((Builder)builder).key;
            this.url = ((Builder)builder).url;
        }
    }

    public static class Builder extends BaseBuilder {
        private String url;
        private String key;

        @Override
        public BaseParam createParam() {
            KeyUrlParam keyUrlParam = new KeyUrlParam();
            keyUrlParam.fill(this);
            return keyUrlParam;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder key(String key) {
            this.key = key;
            return this;
        }

    }

    public KeyUrlParam() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.key);
    }

    protected KeyUrlParam(Parcel in) {
        this.url = in.readString();
        this.key = in.readString();
    }

    public static final Creator<KeyUrlParam> CREATOR = new Creator<KeyUrlParam>() {
        @Override
        public KeyUrlParam createFromParcel(Parcel source) {
            return new KeyUrlParam(source);
        }

        @Override
        public KeyUrlParam[] newArray(int size) {
            return new KeyUrlParam[size];
        }
    };
}
