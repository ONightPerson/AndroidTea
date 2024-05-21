package com.liubz.androidtea.cherish.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 5/14/24 2:59 PM
 */
public class MyLinkedHashMap extends LinkedHashMap {
    private static final int MAX_ENTRIES = 5;

    public MyLinkedHashMap(int initialCapacity,
                           float loadFactor,
                           boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }
}
