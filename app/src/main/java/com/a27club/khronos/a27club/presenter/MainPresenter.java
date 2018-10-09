package com.a27club.khronos.a27club.presenter;


import com.a27club.khronos.a27club.entity.PlayListResponse;
import com.a27club.khronos.a27club.service.PlayListService;
import com.a27club.khronos.a27club.view.MainActivityView;

import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter extends BasePresenter {
    private MainActivityView mView;
    private PlayListService mPlayListService;

    public MainPresenter(MainActivityView mView) {
        this.mView = mView;
        mPlayListService = new PlayListService();
    }

    public void getData(){
        Call<PlayListResponse> mPlayListResponse = mPlayListService.getmPlayListApi().getAllPlayLists();
        mPlayListResponse.enqueue(new PlaylistsCallListener(mView));
    }
    public String getVideoIdFromUrl(String url) {

        String pattern = "(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200C\u200B2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*";

        Pattern compiledPattern = Pattern.compile(pattern);

        Matcher matcher = compiledPattern.matcher(url); //url is youtube url for which you want to extract the id.
        if (matcher.find())

        {
            return matcher.group();
        }

        return matcher.group();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mView = null;
    }


    private static class PlaylistsCallListener implements Callback<PlayListResponse> {

        private WeakReference<MainActivityView> mViews;
        public PlaylistsCallListener(MainActivityView mView) {
            mViews = new WeakReference<>(mView);
        }

        @Override
        public void onResponse(Call<PlayListResponse> call, Response<PlayListResponse> response) {
            if (mViews.get()!=null){
                mViews.get().onGetDataDownUpdateView(response.body().getPlayList());
            }
        }

        @Override
        public void onFailure(Call<PlayListResponse> call, Throwable t) {
            t.fillInStackTrace();
        }
    }
}
