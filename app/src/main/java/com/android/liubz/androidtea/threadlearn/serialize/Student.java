package com.android.liubz.androidtea.threadlearn.serialize;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {

    public String stuNo;
    public String name;
    public String tel;
    public String tClass;

    protected Student(Parcel in) {
        stuNo = in.readString();
        name = in.readString();
        tel = in.readString();
        tClass = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(stuNo);
        dest.writeString(name);
        dest.writeString(tel);
        dest.writeString(tClass);
    }
}
