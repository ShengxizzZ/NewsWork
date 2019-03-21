package com.shengxi.xxwork.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.shengxi.xxwork.utils.eventbus.BindEventBus;
import com.trello.rxlifecycle.components.RxActivity;

import org.greenrobot.eventbus.EventBus;

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
    protected void onResume() {
        super.onResume();
        if (this.getClass().isAnnotationPresent(BindEventBus.class)){
            EventBus.getDefault().register(this);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        if (this.getClass().isAnnotationPresent(BindEventBus.class)){
            EventBus.getDefault().unregister(this);
        }
    }

    protected abstract void finishTask();

    protected abstract void loadData();

    protected abstract void initView();

    protected abstract int getLayoutId();
}
