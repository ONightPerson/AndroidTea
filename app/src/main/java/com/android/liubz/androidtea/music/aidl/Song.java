package com.android.liubz.androidtea.music.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {

    public String name;
    public String author;
    public long duration;

    protected Song(Parcel in) {
        name = in.readString();
        author = in.readString();
        duration = in.readLong();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(author);
        dest.writeLong(duration);
    }
}
