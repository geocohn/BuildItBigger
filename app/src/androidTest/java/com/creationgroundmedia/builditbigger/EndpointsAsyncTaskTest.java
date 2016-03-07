package com.creationgroundmedia.builditbigger;

import android.test.AndroidTestCase;
import android.util.Pair;

import java.util.concurrent.TimeUnit;

/**
 * Created by George Cohn on 3/4/16.
 * Builds a joke request using a dummy AdFollower,
 * waits up to 10 seconds for the joke,
 * and checks to make sure it's not null or empty
 */
public class EndpointsAsyncTaskTest extends AndroidTestCase {

    public void testEndpointsAsyncTask() {
        String result;
        AdFollower adFollower = new AdFollower(getContext(), null);
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(adFollower);
        asyncTask.execute(new Pair<>(getContext(), "hiya"));
        try {
            result = asyncTask.get(10000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            assertTrue(false);
            return;
        }
        assertTrue(result != null && result.length() != 0);
    }

}