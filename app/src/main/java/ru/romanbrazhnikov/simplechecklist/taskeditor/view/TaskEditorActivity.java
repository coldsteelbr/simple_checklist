package ru.romanbrazhnikov.simplechecklist.taskeditor.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import ru.romanbrazhnikov.simplechecklist.R;
import ru.romanbrazhnikov.simplechecklist.base.views.BaseActivity;

/**
 * Created by roman on 25.10.17.
 */

public class TaskEditorActivity extends BaseActivity {

    public static void startNewActivity(Context context) {
        Intent intent = new Intent(context, TaskEditorActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_editor);
    }

    @Override
    public void inject() {
        getAppComponent().inject(this);
    }
}
