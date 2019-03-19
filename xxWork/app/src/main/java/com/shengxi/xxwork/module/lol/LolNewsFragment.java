package com.shengxi.xxwork.module.lol;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.shengxi.xxwork.R;
import com.shengxi.xxwork.base.BaseFragment;
import com.shengxi.xxwork.entity.lolnews.LOLNewsListInfo;
import com.shengxi.xxwork.network.RetrofitManager;
import com.shengxi.xxwork.utils.CommonUtil;

import java.util.Observable;
import java.util.Scanner;

import butterknife.BindView;
import okhttp3.ResponseBody;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class LolNewsFragment extends BaseFragment {

    @BindView(R.id.fra_lol_rollView)
    RollPagerView mRollView;

    @BindView(R.id.fra_lol_recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.fra_lol_refresh)
    SmartRefreshLayout smartRefreshLayout;

    private LOLNewsListInfo mListInfo;

    @Override
    public int getResId() {
        return R.layout.fragment_lol_news;
    }

    @Override
    public void initView() {

        mRollView.setPlayDelay(3000);
        mRollView.setHintView(new ColorPointHintView(this.getContext(),Color.GREEN,Color.WHITE));
        mRollView.isPlaying();

        smartRefreshLayout.autoRefresh();

    }

    @Override
    public void finishTask() {

        RetrofitManager.getLolRollPic()
                .getLolNews()
                .subscribeOn(Schedulers.newThread())
                .compose(this.<ResponseBody>bindToLifecycle())
                .map(new Func1<ResponseBody, LOLNewsListInfo>() {
                    @Override
                    public LOLNewsListInfo call(ResponseBody responseBody) {
                        return new Gson().fromJson(CommonUtil.getResponseBody(responseBody),LOLNewsListInfo.class);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LOLNewsListInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();

                    }

                    @Override
                    public void onNext(LOLNewsListInfo lolNewsListInfo) {
                        mListInfo = lolNewsListInfo;

                    }
                });
    }


    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }


}
