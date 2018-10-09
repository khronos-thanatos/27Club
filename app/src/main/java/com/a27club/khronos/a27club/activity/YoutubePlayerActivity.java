package com.a27club.khronos.a27club.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.a27club.khronos.a27club.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YoutubePlayerActivity extends YouTubeBaseActivity {

    @BindView(R.id.youte_view)
    YouTubePlayerView mYouTubePlayerView;
    private String mVideoID;

    // I know I know but it's just a test app so ...
    public static final String API_KEY = "AIzaSyAYqgmkodjrwmchnF-p6ZCzX3l3lYkcVEc";
    public static final String KEY_VIDEO_ID_INTENT = "VIDEO_ID_INTENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player);
        ButterKnife.bind(this,this);
        mVideoID = getIntent().getStringExtra(KEY_VIDEO_ID_INTENT);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mYouTubePlayerView.initialize(API_KEY,new OnInitializeListener());
    }

    public class   OnInitializeListener implements YouTubePlayer.OnInitializedListener {
        @Override
        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
            youTubePlayer.loadVideo(mVideoID);
        }

        @Override
        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        }
    }
}
