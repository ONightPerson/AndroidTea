package com.android.liubz.androidtea.java.concurrent;

/**
 * Created by liubaozhu on 2019-08-25
 */
public class CircularSet {

    private int[] mArray;
    private int mLen;
    private int mIndex = 0;

    public CircularSet(int size) {
        mArray = new int[size];
        mLen = size;
        // Initialize to a value not produced
        for (int i = 0; i < size; i++) {
            mArray[i] = -1;
        }
    }

    public synchronized void add(int i) {
        mArray[mIndex] = i;
        mIndex = ++mIndex % mLen;
    }

    public synchronized boolean contains(int val) {
        for (int i = 0; i < mLen; i++) {
            if (mArray[i] == val) {
                return true;
            }
        }
        return false;
    }
}
