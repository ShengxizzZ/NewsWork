package com.shengxi.xxwork.network.api;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface HexBoxService {

    //maxnews/app/tag/list?heybox_id=9726103&imei=867830026455933&os_type=Android&os_version=7.0
    // &version=1.2.57&_time=1552798124&hkey=0b2f276b7ddf3585519ce83165c02eab//推荐tablayout
//
//    @GET("/maxnews/app/tag/list")
//    Observable<ResponseBody> getTabList(@QueryMap Map<String,Object>map);
    @GET("maxnews/app/tag/list?heybox_id=9726103&imei=867830026455933&os_type=Android&os_version=7.0/ &version=1.2.57&_time=1552798124&hkey=0b2f276b7ddf3585519ce83165c02eab")
    Observable<ResponseBody> getTabList();


    @GET("maxnews/app/list?tag={tag}&offset=0&limit={limit}&rec_mark=timeline&heybox_id=9726103&imei=867830026455933&os_type=Android&os_version=7.0&version=1.2.57&_time=1552797824&hkey=8c5202f35d0f758479fbfa00b9c84b0c")
    Observable<ResponseBody> getTagNewsList(@Path("tag") String tag,@Path("limit") String limit);
}


