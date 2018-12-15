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

    /**
     * 根据builder创建页面参数，通常实现就是new出参数对象，
     * 然后调用{@link BaseParam#fill(BaseBuilder)}。
     * <p>
     * 这里没用泛型是因为页面参数存在继承关系，
     * 所以builder也会有继承关系。
     *
     * @return 参数对象。
     */
    public abstract Object createParam();
}
