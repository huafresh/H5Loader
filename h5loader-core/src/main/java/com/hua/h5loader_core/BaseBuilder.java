package com.hua.h5loader_core;

import android.content.Context;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/14 10:36
 */

public abstract class BaseBuilder {
    public final void load(Context context) {
        H5LoadManager.get().load(context, this);
    }

    public abstract Object createParam();
}
