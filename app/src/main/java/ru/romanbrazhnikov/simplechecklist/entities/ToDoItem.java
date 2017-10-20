package ru.romanbrazhnikov.simplechecklist.entities;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by roman on 19.10.17.
 */
@Entity
public class ToDoItem {
    @Id
    long id;
    boolean isDone;
    String taskToDO;

    public ToDoItem() {
    }

    public ToDoItem(boolean isDone, String taskToDO) {
        this.isDone = isDone;
        this.taskToDO = taskToDO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getTaskToDO() {
        return taskToDO;
    }

    public void setTaskToDO(String taskToDO) {
        this.taskToDO = taskToDO;
    }
}
