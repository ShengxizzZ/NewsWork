package com.shengxi.xxwork.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shengxi.xxwork.utils.eventbus.BindEventBus;
import com.trello.rxlifecycle.components.RxFragment;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends RxFragment {

    private Unbinder unbinder;

    private View parentView;

    private boolean isVisible;//用户可见标志
    private boolean isPrepared;//判断view是不是初始化完毕
    private boolean isAlreadyLoadData = false;//是否加载过数据


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (parentView == null) {
            parentView = inflater.inflate(getResId(), container, false);

        }
        ViewGroup parent = (ViewGroup) parentView.getParent();
        if (parent != null) {
            parent.removeView(parentView);
        }
        initView();
        isPrepared = true;

        return parentView;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        lazyLoad();
        initData();
        //initEvent();

    }

    @Override
    public void onResume() {
        super.onResume();
        if (this.getClass().isAnnotationPresent(BindEventBus.class)){
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        if (this.getClass().isAnnotationPresent(BindEventBus.class)){
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isVisible = true;
            lazyLoad();
        } else {
            isVisible = false;
        }
    }


    private void lazyLoad() {
        //确保初始化完成
        if (!isVisible || !isPrepared) {
            return;
        }
        if (!isAlreadyLoadData) {
            finishTask();
            isAlreadyLoadData = true;
        }
    }

    public abstract int getResId();

    public abstract void initView();


    public abstract void finishTask();

    public abstract void initData();

    public abstract void initEvent();
}
