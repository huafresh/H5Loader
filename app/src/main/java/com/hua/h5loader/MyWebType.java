package com.hua.h5loader;

import android.content.Context;

import com.hua.h5loader_core.IWebPageType;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/14 15:59
 */

public class MyWebType implements IWebPageType<MyBuilder,Temp> {
    @Override
    public MyBuilder newParamBuilder() {
        return null;
    }

    @Override
    public void load(Context context, Temp param) {

    }
}
