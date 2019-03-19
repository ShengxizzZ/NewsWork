package com.shengxi.xxwork.network.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import rx.Observable;

public interface LOLNewsService {

    @GET("lua/lol_news/recommend?cid=12&areaid=24&reset=false&direction=0&plat=android&version=9854")
    Observable<ResponseBody> getLolNews();
}
