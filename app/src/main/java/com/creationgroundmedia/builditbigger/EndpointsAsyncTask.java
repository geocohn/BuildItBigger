package com.creationgroundmedia.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import com.creationgroundmedia.jokebackend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by George Cohn on 3/2/16.
 * Retrieves a joke from the server and delivers it asynchronously via AdFollower
 */
class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static final String LOG_TAG = EndpointsAsyncTask.class.getSimpleName();
    private static MyApi jokeApiService = null;
    private final AdFollower mAdFollower;

    public EndpointsAsyncTask(AdFollower adFollower) {
        mAdFollower = adFollower;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
//        Log.d(LOG_TAG, "Context, String = " + params[0].first.toString() + ", " + params[0].second);
        if (jokeApiService == null) {  // Only do this once
//            Log.d(LOG_TAG, "First time through");
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            jokeApiService = builder.build();
        }

        Context context = params[0].first;
        String name = params[0].second;

        try {
//            Log.d(LOG_TAG, "Trying JokeApiService.sayHi(\"howdy\")");
            return jokeApiService.sayHi("howdy").execute().getData();
        } catch (IOException e) {
//            Log.d(LOG_TAG, "Catching IO exception");
//            return e.getMessage();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        mAdFollower.setJoke(result);
    }
}