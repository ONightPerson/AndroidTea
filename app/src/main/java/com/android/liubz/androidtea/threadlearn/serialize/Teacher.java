package com.android.liubz.androidtea.threadlearn.serialize;

import java.io.Serializable;

public class Teacher implements Serializable {
    public static final long serialVersionUID = 1l;

    public String name;
    public String course;
    public int tClass;

    @Override
    public String toString() {
        return "[name: " + name + ", course: " + course + ", tClass: " + tClass + "]";
    }
}
