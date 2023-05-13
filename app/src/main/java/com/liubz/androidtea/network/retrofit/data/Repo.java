package com.liubz.androidtea.network.retrofit.data;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Repo {
    @SerializedName("id")
    public long id;
    @SerializedName("node_id")
    public String nodeId;
    @SerializedName("full_name")
    public String fullName;

    @NonNull
    @Override
    public String toString() {
        return "[id=" + id + ", node_id=" + nodeId + ", fullName=" + fullName + "]";
    }
}
