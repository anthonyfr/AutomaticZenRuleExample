package com.anthonyfr.automaticzenruleexample;

import android.util.Log;
import android.net.Uri;
import android.service.notification.ConditionProviderService;

public class MyConditionProviderService extends ConditionProviderService {
    private static String TAG = MyConditionProviderService.class.getSimpleName();

    @Override
    public void onConnected() {
        Log.d(TAG, "onConnected");
    }

    @Override
    public void onSubscribe(final Uri uri) {
        Log.d(TAG, "onSubscribe");
    }

    @Override
    public void onUnsubscribe(final Uri uri){
        Log.d(TAG, "onUnsubscribe");
    }


}
