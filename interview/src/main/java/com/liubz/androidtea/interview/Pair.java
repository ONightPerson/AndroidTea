package com.liubz.androidtea.interview;

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

    @Override
    public String toString() {
        return "[" + this.first + ", " + this.second + "]";
    }
}
