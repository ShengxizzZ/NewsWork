package com.shengxi.xxwork.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.trello.rxlifecycle.components.RxActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends RxActivity {

    private Unbinder unbinder;

    @Override
    public void onCreate( Bundle savedInstanceState,  PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        initView();
        loadData();
        finishTask();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    protected abstract void finishTask();

    protected abstract void loadData();

    protected abstract void initView();

    protected abstract int getLayoutId();
}
