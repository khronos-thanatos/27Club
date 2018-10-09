package com.a27club.khronos.a27club.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.a27club.khronos.a27club.R;
import com.a27club.khronos.a27club.adaptor.MoviesAdapter;
import com.a27club.khronos.a27club.entity.PlayLists;
import com.a27club.khronos.a27club.presenter.MainPresenter;
import com.a27club.khronos.a27club.view.MainActivityView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity  extends BaseActivity<MainPresenter> implements MainActivityView,MoviesAdapter.onMovieAdapter{

    @BindView(R.id.recycleView)
    RecyclerView recyclerView;
    MoviesAdapter moviesAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("MainActivity", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this,this);

        createPresenter(this).getData();

    }

    @NonNull
    @Override
    public MainPresenter createPresenter(@NonNull Context context) {
        return new MainPresenter(this);
    }

    @Override
    public void onGetDataDownUpdateView(List<PlayLists> body) {
        MoviesAdapter adapter = new MoviesAdapter(body,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onMovieAdapterClicked(String link) {
        String videoId = presenter.getVideoIdFromUrl(link);
        Intent intent = new Intent(this,YoutubePlayerActivity.class);
        intent.putExtra(YoutubePlayerActivity.KEY_VIDEO_ID_INTENT,videoId);
        startActivity(intent);
    }
}
