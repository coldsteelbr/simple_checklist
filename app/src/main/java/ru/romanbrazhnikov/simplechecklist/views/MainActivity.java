package ru.romanbrazhnikov.simplechecklist.views;

import android.os.Bundle;

import javax.inject.Inject;

import io.objectbox.Box;
import ru.romanbrazhnikov.simplechecklist.R;
import ru.romanbrazhnikov.simplechecklist.base.views.BaseActivity;
import ru.romanbrazhnikov.simplechecklist.entities.SampleEntity;

public class MainActivity extends BaseActivity {

    @Inject
    Box<SampleEntity> mSampleEntityBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void inject() {
        getAppComponent().inject(this);
    }

}
