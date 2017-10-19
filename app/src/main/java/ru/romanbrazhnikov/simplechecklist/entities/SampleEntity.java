package ru.romanbrazhnikov.simplechecklist.entities;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by roman on 19.10.17.
 */
@Entity
public class SampleEntity {
    @Id
    long id;
    String content;
}
