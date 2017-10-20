package ru.romanbrazhnikov.simplechecklist.views.viewholders;

import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import ru.romanbrazhnikov.simplechecklist.R;
import ru.romanbrazhnikov.simplechecklist.base.views.viewholders.BaseViewHolder;
import ru.romanbrazhnikov.simplechecklist.entities.ToDoItem;

/**
 * Created by roman on 20.10.17.
 */

public class ToDoItemViewHolder extends BaseViewHolder<ToDoItem> {
    private TextView tvTaskToDo;
    private Switch swIsDone;

    public ToDoItemViewHolder(View itemView) {
        super(itemView);
        tvTaskToDo = itemView.findViewById(R.id.tv_task_todo);
        swIsDone = itemView.findViewById(R.id.sw_is_done);
    }

    @Override
    public void bindItem(ToDoItem item) {
        tvTaskToDo.setText(item.getTaskToDO());
        swIsDone.setChecked(item.isDone());
    }
}
