package com.example.apahlavan1.youtubeplayer;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YouTubeActivity extends YouTubeBaseActivity
            implements YouTubePlayer.OnInitializedListener
{
    private String GOOGLE_API_KEY = "AIzaSyBrUie6TUyc6Ab-386qI0A2LD0ic5yoysc";
    private String YOUTUBE_VIDEO_ID = "tfIZKRdXKks";
    private String YOUTUBE_PLAYLIST = "PLhuERNaQ58tmNimEmIJh17PppfywtrnHA";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube);
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(GOOGLE_API_KEY, this);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
    }



    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Toast.makeText(this, "Initialized YouTube Player Successfully", Toast.LENGTH_LONG).show();



        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);


        if(!wasRestored){
//            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
            youTubePlayer.loadPlaylist(YOUTUBE_PLAYLIST);
//            youTubePlayer.play();
            youTubePlayer.setFullscreen(true);
        }
    }


    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {
            Toast.makeText(YouTubeActivity.this, "Good, video is playing ok!", Toast.LENGTH_LONG).show();

        }

        @Override
        public void onPaused() {
            Toast.makeText(YouTubeActivity.this, "Video has paused", Toast.LENGTH_LONG).show();

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }

    };

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {
            Toast.makeText(YouTubeActivity.this, "Click Ad now, make the video creator rich!", Toast.LENGTH_LONG).show();

        }

        @Override
        public void onVideoStarted() {
            Toast.makeText(YouTubeActivity.this, "Video has started!", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onVideoEnded() {
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }

    };

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failed Initialize YouTube Player", Toast.LENGTH_LONG).show();

    }

}
