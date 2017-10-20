package ru.romanbrazhnikov.simplechecklist.views.viewholders;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import javax.inject.Inject;

import ru.romanbrazhnikov.simplechecklist.R;
import ru.romanbrazhnikov.simplechecklist.base.views.viewholders.BaseViewHolder;
import ru.romanbrazhnikov.simplechecklist.entities.ToDoItem;
import ru.romanbrazhnikov.simplechecklist.repository.CommonRepository;
import ru.romanbrazhnikov.simplechecklist.repository.ICommonRepository;

/**
 * Created by roman on 20.10.17.
 */

public class ToDoItemViewHolder extends BaseViewHolder<ToDoItem> {

    ICommonRepository mCommonRepository;

    private TextView tvTaskToDo;
    private CheckBox chIsDone;
    private ToDoItem mItem;

    public ToDoItemViewHolder(View itemView) {
        super(itemView);
        // TODO: rid of such a singleton
        mCommonRepository = CommonRepository.getInstance();
        tvTaskToDo = itemView.findViewById(R.id.tv_task_todo);
        chIsDone = itemView.findViewById(R.id.ch_is_done);
        chIsDone.setOnCheckedChangeListener(new DoneListener());
    }

    @Override
    public void bindItem(ToDoItem item) {
        // item
        mItem = item;
        // widgets
        tvTaskToDo.setText(item.getTaskToDO());
        chIsDone.setChecked(item.isDone());
    }

    class DoneListener implements CheckBox.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            mItem.setDone(isChecked);
            mCommonRepository.putItem(mItem);
        }
    }

}
