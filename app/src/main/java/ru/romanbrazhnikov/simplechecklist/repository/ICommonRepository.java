package ru.romanbrazhnikov.simplechecklist.repository;

import java.util.List;

import io.objectbox.Box;
import ru.romanbrazhnikov.simplechecklist.entities.ToDoItem;

/**
 * Created by roman on 20.10.17.
 */

public interface ICommonRepository {
    List<ToDoItem> getAllToDoItems();
    void putItem(ToDoItem item);
}
