package com.hua.h5loader;

import com.hua.h5loader_core.BarParam;
import com.hua.h5loader_core.BaseBuilder;

/**
 * 这个类展示了自定义页面类型时如何自定义页面的参数。
 * 这个例子扩展了标题栏页面类型，增加了一个进度条类型参数。
 *
 * PS：虽然写法有点麻烦，但是其实自定义页面类型的场景并不是很频繁，
 * 而且这种写法可以使使用者以链式调用的方式配置参数，综合来讲是利大于弊。
 *
 * @author hua
 * @version 1.0
 * @date 2018/12/15
 */
public class ProgressParam extends BarParam {

    private int progressType;

    @Override
    public void fill(BaseBuilder builder) {
        super.fill(builder);
        if (builder instanceof Builder) {
            this.progressType = ((Builder) builder).progressType;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getProgressType() {
        return progressType;
    }

    public static class Builder extends BarParam.Builder {
        private int progressType;

        public Builder progressType(int progressType) {
            this.progressType = progressType;
            return this;
        }

        @Override
        public ProgressParam createParam() {
            ProgressParam param = new ProgressParam();
            param.fill(this);
            return param;
        }
    }
}
