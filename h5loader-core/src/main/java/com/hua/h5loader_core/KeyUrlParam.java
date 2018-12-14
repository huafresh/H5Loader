package com.hua.h5loader_core;

import android.text.TextUtils;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/13 13:49
 */

public class KeyUrlParam extends BaseParam{
    public String url;
    public String key;

    public static Builder newBuilder(){
        return new Builder();
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
        public Object createParam() {
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
}
