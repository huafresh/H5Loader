package com.hua.h5loader_core;

import android.support.v7.app.AppCompatActivity;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/13 10:07
 */

public class ActivityH5UIContainer extends AppCompatActivity implements IWebContainer<String> {
    @Override
    public int type() {
        return 0;
    }

    @Override
    public void load(String param) {

    }
}
