package com.creationgroundmedia.builditbigger;

/**
 * Created by George Cohn on 3/1/16.
 * This is a stub for the paid version
 * so that it doesn't show an interstitial ad
 */

import android.content.Context;

class AddAd {
    public AddAd(Context context) {
    }

    public void show(AdFollower adFollower) {
        adFollower.setAdClosed();
    }
}