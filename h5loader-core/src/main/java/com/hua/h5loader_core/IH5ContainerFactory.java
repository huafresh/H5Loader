package com.hua.h5loader_core;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/13 10:30
 */

public interface IH5ContainerFactory {
    IWebContainer getContainer(int type);
}
