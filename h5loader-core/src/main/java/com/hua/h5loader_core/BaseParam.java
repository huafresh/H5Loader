package com.hua.h5loader_core;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/14 17:52
 */

public abstract class BaseParam {

    /**
     * builder创建参数时会调用此方法填充参数对象。
     * 这里传入的是BaseBuilder，因此实现需要强转为自身的builder对象。
     *
     * @param builder the builder
     */
    public abstract void fill(BaseBuilder builder);

}
