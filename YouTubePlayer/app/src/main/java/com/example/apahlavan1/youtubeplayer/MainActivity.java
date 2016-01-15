package com.example.apahlavan1.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
            implements View.OnClickListener
{

    private Button btnSingle;
    private  Button btnStandalone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnSingle = (Button) findViewById(R.id.btnPlaySingle);
        btnSingle.setOnClickListener(this);
        btnStandalone = (Button) findViewById(R.id.btnStandalone);
        btnStandalone.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
//        YouTubePlayer youTubePlayer = new YouTubePlayer() {
//            @Override
//            public void release() {
//
//            }
//
//            @Override
//            public void cueVideo(String s) {
//
//            }
//
//            @Override
//            public void cueVideo(String s, int i) {
//
//            }
//
//            @Override
//            public void loadVideo(String s) {
//
//            }
//
//            @Override
//            public void loadVideo(String s, int i) {
//
//            }
//
//            @Override
//            public void cuePlaylist(String s) {
//
//            }
//
//            @Override
//            public void cuePlaylist(String s, int i, int i1) {
//
//            }
//
//            @Override
//            public void loadPlaylist(String s) {
//
//            }
//
//            @Override
//            public void loadPlaylist(String s, int i, int i1) {
//
//            }
//
//            @Override
//            public void cueVideos(List<String> list) {
//
//            }
//
//            @Override
//            public void cueVideos(List<String> list, int i, int i1) {
//
//            }
//
//            @Override
//            public void loadVideos(List<String> list) {
//
//            }
//
//            @Override
//            public void loadVideos(List<String> list, int i, int i1) {
//
//            }
//
//            @Override
//            public void play() {
//
//            }
//
//            @Override
//            public void pause() {
//
//            }
//
//            @Override
//            public boolean isPlaying() {
//                return false;
//            }
//
//            @Override
//            public boolean hasNext() {
//                return false;
//            }
//
//            @Override
//            public boolean hasPrevious() {
//                return false;
//            }
//
//            @Override
//            public void next() {
//
//            }
//
//            @Override
//            public void previous() {
//
//            }
//
//            @Override
//            public int getCurrentTimeMillis() {
//                return 0;
//            }
//
//            @Override
//            public int getDurationMillis() {
//                return 0;
//            }
//
//            @Override
//            public void seekToMillis(int i) {
//
//            }
//
//            @Override
//            public void seekRelativeMillis(int i) {
//
//            }
//
//            @Override
//            public void setFullscreen(boolean b) {
//
//            }
//
//            @Override
//            public void setOnFullscreenListener(OnFullscreenListener onFullscreenListener) {
//
//            }
//
//            @Override
//            public void setFullscreenControlFlags(int i) {
//
//            }
//
//            @Override
//            public int getFullscreenControlFlags() {
//                return 0;
//            }
//
//            @Override
//            public void addFullscreenControlFlag(int i) {
//
//            }
//
//            @Override
//            public void setPlayerStyle(PlayerStyle playerStyle) {
//
//            }
//
//            @Override
//            public void setShowFullscreenButton(boolean b) {
//
//            }
//
//            @Override
//            public void setManageAudioFocus(boolean b) {
//
//            }
//
//            @Override
//            public void setPlaylistEventListener(PlaylistEventListener playlistEventListener) {
//
//            }
//
//            @Override
//            public void setPlayerStateChangeListener(PlayerStateChangeListener playerStateChangeListener) {
//
//            }
//
//            @Override
//            public void setPlaybackEventListener(PlaybackEventListener playbackEventListener) {
//
//            }
//        };

        switch (v.getId()){
            case R.id.btnPlaySingle:
                intent = new Intent(MainActivity.this, YouTubeActivity.class);
                break;
            case R.id.btnStandalone:
                intent = new Intent(MainActivity.this, StandaloneActivity.class);
                break;
            default:
        }

        if(intent != null){
            startActivity(intent);
//            youTubePlayer.setFullscreen(true);
        }
    }
}
