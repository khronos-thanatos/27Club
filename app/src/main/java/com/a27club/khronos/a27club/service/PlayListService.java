package com.a27club.khronos.a27club.service;


import com.a27club.khronos.a27club.entity.PlayListResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class PlayListService {
    private static final String URL = "http://demo6483760.mockable.io/";

    private PlaylistApi mPlayListApi;

    public PlayListService() {
        Retrofit mRetrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(URL).build();
        mPlayListApi = mRetrofit.create(PlaylistApi.class);
    }

    public PlaylistApi getmPlayListApi() {
        return mPlayListApi;
    }

    public interface PlaylistApi{
        @GET("json.json")
        Call<PlayListResponse> getAllPlayLists();
    }
}
