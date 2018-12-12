package com.hua.h5loader_core;

/**
 * @author hua
 * @version 1.0
 * @date 2018/12/12
 */
public abstract class AbstractWebkitPool implements IPool<IWebkit> {



    @Override
    public IWebkit get(String key) {
        return null;
    }

    @Override
    public IWebkit getNew(String key) {
        return null;
    }

    protected abstract IWebkit createWebkit();
}
