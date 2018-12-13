package com.hua.h5loader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hua.h5loader_core.H5LoadManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        H5LoadManager.get().loadUrlWithCustomContainer("",1, MyBuilder.class)
                .myKey();
        H5LoadManager.get().loadH5(1,MyBuilder.class)
                .myKey();



    }
}
