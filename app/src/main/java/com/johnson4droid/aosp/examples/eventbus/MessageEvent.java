package com.johnson4droid.aosp.examples.eventbus;

/**
 * Created by zhoudaihui on 2016/6/29.
 */
public class MessageEvent {
    private final String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
