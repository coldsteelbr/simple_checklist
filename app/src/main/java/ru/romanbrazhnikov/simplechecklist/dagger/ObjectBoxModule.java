package ru.romanbrazhnikov.simplechecklist.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import ru.romanbrazhnikov.simplechecklist.application.MyApp;
import ru.romanbrazhnikov.simplechecklist.entities.MyObjectBox;
import ru.romanbrazhnikov.simplechecklist.entities.ToDoItem;

/**
 * Created by roman on 19.10.17.
 */

@Module
public class ObjectBoxModule {
    private BoxStore mStore;

    public ObjectBoxModule(MyApp application) {
        mStore = MyObjectBox.builder().androidContext(application).build();
    }

    @Provides
    @Singleton
    BoxStore provideBoxStore() {
        return mStore;
    }

    @Provides
    Box<ToDoItem> provideBoxForMyEntity() {
        return mStore.boxFor(ToDoItem.class);
    }

}
