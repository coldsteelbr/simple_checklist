package ru.romanbrazhnikov.simplechecklist.application;

import android.app.Application;

import ru.romanbrazhnikov.simplechecklist.dagger.AppComponent;
import ru.romanbrazhnikov.simplechecklist.dagger.AppModule;
import ru.romanbrazhnikov.simplechecklist.dagger.DaggerAppComponent;
import ru.romanbrazhnikov.simplechecklist.dagger.ObjectBoxModule;

/**
 * Created by roman on 19.10.17.
 */

public class MyApp extends Application {
    private AppComponent mAppComponent;
    //private RepoSubComponent mRepoSubComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .objectBoxModule(new ObjectBoxModule(this))
                .build();

        /* TODO: SubComponent
        mRepoSubComponent = DaggerRepoSubComponent.builder()
                .appComponent(mAppComponent)
                .commonRepositoryModule(new CommonRepositoryModule(new CommonRepository()))
                .build();
        */
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
