package com.android.liubz.androidtea.java.producer_consumer.bean;

/**
 * 测验区的习题栏
 * Created by liubaozhu on 2019-09-26
 */
public class Column {

    Exercise exercise;

    public void consume() {
        this.exercise = null;
    }

    public void assign(Exercise exercise) {
        this.exercise = exercise;
    }

    public boolean hasDone() {
        return this.exercise == null;
    }
}
