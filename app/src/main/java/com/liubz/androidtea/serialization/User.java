package com.liubz.androidtea.serialization;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 11/30/23 2:55 PM
 */
public class User implements Parcelable {
    public int id;
    public String name;

    protected User(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    // 将当前对象写入到序列化结构中
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }

    // 返回当前对象的内容描述。如果还有文件描述符，返回1，否则返回0
    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        // 从序列化对象中创建原始对象
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }
        // 创建指定长度的原始对象数组
        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
