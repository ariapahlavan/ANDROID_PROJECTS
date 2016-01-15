package com.example.apahlavan1.flickrbrowser;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by apahlavan1 on 1/9/2016.
 */

enum DownloadStatus {
    IDLE,
    PROCESSING,
    NOT_INITIALISED,
    FAILED_OR_EMPTY,
    OK
}
public class GetRawData {
    private String LOG_TAG = GetRawData.class.getSimpleName();
    private String rawUrl, data;
    private DownloadStatus downloadStatus;

    public GetRawData(String rawUrl) {
        this.rawUrl = rawUrl;
        this.downloadStatus = DownloadStatus.IDLE;
    }

    public void reset(){
        this.downloadStatus = DownloadStatus.IDLE;
        this.rawUrl = null;
        this.data = null;
    }

    public String getData() {
        return data;
    }

    public DownloadStatus getDownloadStatus() {
        return downloadStatus;
    }

    public class DownloadRawData extends AsyncTask<String, Void, String>{
        protected  void onPostExecute(String webData){
            //TODO Fill in later
        }

        protected String doInBackground(String... params){
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            if(params == null)
                return null;

            try {
                URL url = new URL(params[0]);

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                if(inputStream == null)
                    return null;

                StringBuffer buffer = new StringBuffer();
                reader = new BufferedReader(new InputStreamReader(inputStream));


            }
            catch (IOException e){
                Log.d(LOG_TAG, "");
            } finally {

            }
        }
    }
}
