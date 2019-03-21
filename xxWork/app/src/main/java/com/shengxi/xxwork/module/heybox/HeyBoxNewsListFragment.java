package com.shengxi.xxwork.module.heybox;

import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.shengxi.xxwork.R;
import com.shengxi.xxwork.base.BaseFragment;
import com.shengxi.xxwork.entity.HeyBoxTabListInfo;
import com.shengxi.xxwork.network.RetrofitManager;
import com.shengxi.xxwork.utils.CommonUtil;
import com.shengxi.xxwork.utils.eventbus.BindEventBus;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


@BindEventBus
public class HeyBoxNewsListFragment extends BaseFragment {


    @BindView(R.id.fra_heybox_refresh)
    SmartRefreshLayout refreshLayout;

    @BindView(R.id.fra_heybox_list)
    RecyclerView mList;

    private HeyBoxTabListInfo tabListInfo;
    private static final String TAB_TAG = "tag";

    @Override
    public int getResId() {
        return R.layout.fragment_heybox;
    }

    @Override
    public void initView() {
        refreshLayout.setRefreshHeader(new ClassicsHeader(this.getContext()));
        refreshLayout.setRefreshFooter(new ClassicsFooter(this.getContext()));
        refreshLayout.autoRefresh();
    }

    @Override
    public void finishTask() {
        RetrofitManager.getTabTag().getTabList()
                .compose(this.<ResponseBody>bindToLifecycle())
                .subscribeOn(Schedulers.newThread())
                .map(new Func1<ResponseBody, HeyBoxTabListInfo>() {
                    @Override
                    public HeyBoxTabListInfo call(ResponseBody responseBody) {
                        return new Gson().fromJson(CommonUtil.getResponseBody(responseBody),HeyBoxTabListInfo.class);
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HeyBoxTabListInfo>() {
                    @Override
                    public void call(HeyBoxTabListInfo heyBoxTabListInfo) {
                        tabListInfo = heyBoxTabListInfo;
                        initEvent();

                    }
                });


    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {
        EventBus.getDefault().post(tabListInfo);
    }
}
