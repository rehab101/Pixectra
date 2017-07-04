package com.vikkyb.Picx.pixectra;

import android.app.Application;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Montserrat-Light.ttf"); // font from assets: "assets/fonts/Roboto-Regular.ttf
    }
    }