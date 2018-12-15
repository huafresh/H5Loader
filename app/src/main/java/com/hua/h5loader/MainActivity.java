package com.hua.h5loader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hua.h5loader_core.H5LoadManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://www.baidu.com";

        //使用H5LoaderManager默认提供的页面类型加载h5
        //打开h5不带标题
        H5LoadManager.get().openCommWeb()
                .url(url)
                //传key则可能会对webView做缓存
                //之所以说可能是因为缓存是页面类型实现者控制的，
                //默认实现是有缓存的。
                .key("baidu")
                .start(this);

        //打开带标题
        H5LoadManager.get().openBarWeb()
                .toolbarBacColor(getResources().getColor(R.color.colorPrimary))
                .title("h5标题")
                .titleColor(getResources().getColor(android.R.color.white))
                .start(this);

        //打开自定义样式的
        //先要注册（全局调用一次即可）
        H5LoadManager.get().registerWebPageType(new ProgressWebPage());
        H5LoadManager.get().beginBuildParam(ProgressWebPage.WEB_TYPE_PROGRESS, ProgressParam.Builder.class)
                //这里可以链式调用设置自定义参数
                .progressType(1)
                .start(this);

    }
}
