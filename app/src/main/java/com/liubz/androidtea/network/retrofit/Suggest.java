package com.liubz.androidtea.network.retrofit;

import java.util.Arrays;
import java.util.List;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/5/12 4:56 PM
 */
public class Suggest {

    public Result result;

    public Data data;

    public static class Result {
        public String msg;
        public int code;
    }

    public static class Data {
        public String query;
        public String language;
        public List<Entry> entries;

        @Override
        public String toString() {
            return "Data{" +
              "query='" + query + '\'' +
              ", language='" + language + '\'' +
              ", entries=" + Arrays.toString(entries == null ? null : entries.toArray()) +
              '}';
        }
    }

    public static class Entry {
        public String explain;
        public String entry;
    }
}