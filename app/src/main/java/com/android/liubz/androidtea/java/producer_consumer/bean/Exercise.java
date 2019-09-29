package com.android.liubz.androidtea.java.producer_consumer.bean;

/**
 * Created by liubaozhu on 2019-09-26
 */
public class Exercise {

    int id;

    public Exercise(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "[exercise] " + id;
    }
}
