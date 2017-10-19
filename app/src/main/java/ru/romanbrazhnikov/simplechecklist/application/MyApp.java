package ru.romanbrazhnikov.simplechecklist.application;

import android.app.Application;

import ru.romanbrazhnikov.simplechecklist.dagger.AppComponent;
import ru.romanbrazhnikov.simplechecklist.dagger.AppModule;
import ru.romanbrazhnikov.simplechecklist.dagger.DaggerAppComponent;

/**
 * Created by roman on 19.10.17.
 */

public class MyApp extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                //.anyModule(new AnyModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
