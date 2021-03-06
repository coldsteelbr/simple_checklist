package ru.romanbrazhnikov.simplechecklist.dagger;

import javax.inject.Singleton;

import dagger.Component;
import ru.romanbrazhnikov.simplechecklist.taskeditor.view.TaskEditorActivity;
import ru.romanbrazhnikov.simplechecklist.views.ToDoListActivity;

/**
 * Created by roman on 19.10.17.
 */

@Singleton
@Component(
        modules = {
                AppModule.class,
                ObjectBoxModule.class
        })
public interface AppComponent {
    void inject(ToDoListActivity activity);
    void inject(TaskEditorActivity activity);
    //void inject(ICommonRepository repository);
    //ICommonRepository repo();
}
