package com.hua.h5loader_core;

/**
 * @author hua
 * @version 1.0
 * @date 2018/12/12
 */
public interface IPool<T> {

    T get(String key);

    T getNew(String key);
}
