package ru.romanbrazhnikov.simplechecklist.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.objectbox.Box;
import ru.romanbrazhnikov.simplechecklist.R;
import ru.romanbrazhnikov.simplechecklist.base.views.BaseRecyclerViewActivity;
import ru.romanbrazhnikov.simplechecklist.entities.ToDoItem;
import ru.romanbrazhnikov.simplechecklist.repository.CommonRepository;
import ru.romanbrazhnikov.simplechecklist.repository.ICommonRepository;
import ru.romanbrazhnikov.simplechecklist.taskeditor.view.TaskEditorActivity;
import ru.romanbrazhnikov.simplechecklist.views.viewholders.ToDoItemViewHolder;

public class ToDoListActivity extends BaseRecyclerViewActivity<ToDoItem, ToDoItemViewHolder> {

    @Inject
    Box<ToDoItem> mToDoItemBox;
    ICommonRepository mCommonRepository;

    @BindView(R.id.fab_add_task)
    FloatingActionButton fabAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);

        // TODO: use sub component
        mCommonRepository = CommonRepository.getInstance();
        ((CommonRepository) mCommonRepository).init(mToDoItemBox);

        /*
        for (int i = 0; i < 30; i++) {
            mToDoItemBox.put(new ToDoItem(false, "Sample task" + String.valueOf(i)));
        }
        //*/

    }

    @OnClick(R.id.fab_add_task)
    protected void fabAddTaskClick() {
        TaskEditorActivity.startNewActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    // UPDATE UI EXAMPLE BASED ON OBJECT BOX
    private void updateUI() {
        List<ToDoItem> filteredRecords = mCommonRepository.getAllToDoItems();

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
