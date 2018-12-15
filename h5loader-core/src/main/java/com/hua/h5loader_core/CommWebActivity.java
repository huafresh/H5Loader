package com.hua.h5loader_core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/14 9:26
 */

public class CommWebActivity extends AppCompatActivity {

    public static final String FRAGMENT_TAG_COMM_WEB = "fragment_tag_comm_web";
    static ArrayDeque<Fragment> pendingFragment = new ArrayDeque<>();

    public static void startFragment(Context context, Fragment fragment) {
        pendingFragment.addLast(fragment);

        Intent intent = new Intent(context, CommWebActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comm_web);

        Fragment fragment = pendingFragment.pollFirst();
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl_container, fragment, FRAGMENT_TAG_COMM_WEB)
                    .commit();
        } else {
            fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_COMM_WEB);
            if (fragment == null) {
                finish();
            }
        }
    }
}
