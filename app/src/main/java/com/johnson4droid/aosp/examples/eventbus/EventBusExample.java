package com.johnson4droid.aosp.examples.eventbus;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by zhoudaihui on 2016/6/29.
 */
public class EventBusExample {

    private static final String TAG = EventBusExample.class.getSimpleName();

    /**
     * 1. For using EventBus , you should first add the gradle dependency to the file 'build.gradle'
     * compile 'org.greenrobot:eventbus:3.0.0'
     */

    /**
     * 2. Define events {@linkplain MessageEvent}
     */

    /***
     * 3. Prepare subscribers
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        // TODO: 2016/6/29 handle the event
        String msg = event.getMessage();
        Log.d(TAG,"Received msg:"+msg);
    }

    /**
     * This method can {@linkplain Activity#onStart()} or {@linkplain Fragment#onStart()}
     */
    public void onStart() {
        EventBus.getDefault().register(this);
    }

    /**
     * This method can be {@linkplain Activity#onStop()} or {@linkplain Fragment#onStop()}
     */
    public void onStop() {
        EventBus.getDefault().unregister(this);
    }

    /***
     * 4. post event
     */
    public void postEvent() {
        EventBus.getDefault().post(new MessageEvent("Hello,everyone !"));
    }

}
