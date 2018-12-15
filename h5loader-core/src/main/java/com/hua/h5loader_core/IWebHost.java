package com.hua.h5loader_core;

import android.content.Context;

/**
 * {@link IWebPageType}对象寄存的容器，可能是Activity，
 * 或者是Fragment。
 *
 * @author hua
 * @version 1.0
 * @date 2018/12/15
 */
interface IWebHost {

    void finish();

    Context getContext();
}
