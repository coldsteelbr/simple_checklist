package ru.romanbrazhnikov.simplechecklist.repository;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.query.Query;
import ru.romanbrazhnikov.simplechecklist.entities.ToDoItem;

/**
 * Created by roman on 20.10.17.
 * <p>
 * Common repository provide data and hide details of implementation
 * TODO: Rx
 */

public class CommonRepository implements ICommonRepository {


    private static CommonRepository sInstance = null;
    public static CommonRepository getInstance(){
        if(sInstance == null){
            sInstance = new CommonRepository();
        }
        return sInstance;
    }

    private CommonRepository(){
        // Private, empty, for singleton
    }

    private Box<ToDoItem> mToDoItemBox;

    public void init(Box<ToDoItem> box) {
        mToDoItemBox = box;
    }

    @Override
    public List<ToDoItem> getAllToDoItems() {
        // getting items and refreshing list
        Query<ToDoItem> queryAll
                = mToDoItemBox.query()
                .build();

        return queryAll.find();
    }

    @Override
    public void putItem(ToDoItem item) {
        mToDoItemBox.put(item);
    }
}
