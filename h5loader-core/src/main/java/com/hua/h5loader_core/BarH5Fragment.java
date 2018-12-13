package com.hua.h5loader_core;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/13 10:14
 */

public class BarH5Fragment extends CommWebFragment {

    @Override
    public IWebContainer<?> getContainer() {
        return new IWebContainer<TkWebView>() {
            @Override
            public int type() {
                return 0;
            }

            @Override
            public void load(TkWebView param) {

            }
        };
    }
}
