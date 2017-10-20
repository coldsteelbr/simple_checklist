package ru.romanbrazhnikov.simplechecklist.views;

import android.os.Bundle;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import io.objectbox.Box;
import io.objectbox.query.Query;
import ru.romanbrazhnikov.simplechecklist.R;
import ru.romanbrazhnikov.simplechecklist.base.views.BaseRecyclerViewActivity;
import ru.romanbrazhnikov.simplechecklist.entities.ToDoItem;
import ru.romanbrazhnikov.simplechecklist.views.viewholders.ToDoItemViewHolder;

public class ToDoListActivity extends BaseRecyclerViewActivity<ToDoItem, ToDoItemViewHolder> {

    @Inject
    Box<ToDoItem> mToDoItemBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        for (int i = 0; i < 15; i++) {
            mToDoItemBox.put(new ToDoItem(false, "Sample task" + String.valueOf(i)));
        }
        */

    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    // UPDATE UI EXAMPLE BASED ON OBJECT BOX
    private void updateUI() {
        // getting items and refreshing list
        Query<ToDoItem> queryAll
                = mToDoItemBox.query()
                .build();

        List<ToDoItem> filteredRecords = queryAll.find();

        refreshList(filteredRecords);
    }

    @Override
    protected int getRecyclerViewID() {
        return R.id.rv_todo_list;
    }

    @Override
    protected int getItemLayoutID() {
        return R.layout.item_todo;
    }

    @Override
    protected ToDoItemViewHolder newViewHolder(View itemView) {
        return new ToDoItemViewHolder(itemView);
    }

    @Override
    protected int getScreenLayout() {
        return R.layout.activity_todo_list;
    }

    @Override
    public void inject() {
        getAppComponent().inject(this);
    }

}
