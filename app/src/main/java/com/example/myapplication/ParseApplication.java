package com.example.myapplication;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("5jCECry8dYWC87mHK3wGeQoG2raJL8x0EHFIwQd5")
                .clientKey("k461nW4pTUOpQFgzRnp5yxBExInZHg3qbc3jUpIG")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
