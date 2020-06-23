package com.android.liubz.androidtea.java.interview;

import androidx.annotation.NonNull;

/**
 * Created by liubaozhu on 2020-01-04
 */
public class Pair<T, U> {
    public final T first;
    public final U second;

    public Pair(T t, U u) {
        this.first = t;
        this.second = u;
    }

    @NonNull
    @Override
    public String toString() {
        return "[" + this.first + ", " + this.second + "]";
    }
}
