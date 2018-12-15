package com.hua.h5loader_core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayDeque;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/14 9:26
 */

public class CommWebActivity extends AppCompatActivity implements IWebHost {

    private static final String KEY_PARAM = "param";
    private IWebPageType webPageType;

    public static void startWebPage(Context context, BaseParam param) {
        Intent intent = new Intent(context, CommWebActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        intent.putExtra(KEY_PARAM, param);
        context.startActivity(intent);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comm_web);

        FrameLayout container = findViewById(R.id.fl_container);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            BaseParam param = extras.getParcelable(KEY_PARAM);
            if (param != null) {
                webPageType.onAttachToHost(this);
                webPageType = H5LoadManager.get().getWebPageTypeById(param.getWebType());
                View contentView = webPageType.onCreateView(this,
                        LayoutInflater.from(this), container, param);
                container.addView(contentView,
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webPageType != null) {
            webPageType.onDestroyView();
            webPageType.onDetachFromHost();
        }
    }

    @Override
    public Context getContext() {
        return this;
    }
}
