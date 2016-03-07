package com.creationgroundmedia.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ProgressBar;

import com.creationgroundmedia.showjokelib.ShowJoke;

/**
 * Created by George Cohn on 3/2/16.
 * This class is used to launch the SHowJoke activity
 * when and only when the joke has been delivered
 * and the ad (if any) has been closed.
 */
class AdFollower {
    private final ProgressBar mSpinner;
    private final Context mContext;
    private String mJoke = null;
    private boolean mAdClosed = false;

    AdFollower(Context context, ProgressBar spinner) {
        mContext = context;
        mSpinner = spinner;
    }

    public void setJoke(@NonNull String joke) {
        mJoke = joke;
        if (mAdClosed) {
            showJoke(mContext, mJoke);
        }
    }

    public void setAdClosed() {
        mAdClosed = true;
        if (mJoke != null) {
            showJoke(mContext, mJoke);
        }
    }

    private void showJoke(Context mContext, String joke) {
        mSpinner.setVisibility(View.GONE);
        Intent intent = new Intent(mContext, ShowJoke.class);
        intent.putExtra(ShowJoke.JOKETEXT, joke);
        mContext.startActivity(intent);
    }
}
