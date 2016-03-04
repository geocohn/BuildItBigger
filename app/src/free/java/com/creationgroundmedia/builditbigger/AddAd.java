package com.creationgroundmedia.builditbigger;

import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by George Cohn on 3/1/16.
 * This class shows an interstitial ad
 */
public class AddAd {
    private final InterstitialAd mInterstitialAd;
    private AdFollower mAdFollower;

    public AddAd(Context context) {
        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                mAdFollower.setAdClosed();
            }
        });

        requestNewInterstitial();
    }
    public void show(AdFollower adFollower) {
        mAdFollower = adFollower;
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }
}
