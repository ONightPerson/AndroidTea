package com.liubz.androidtea.cherish.datastructure.heap;

import com.liubz.androidtea.cherish.datastructure.bean.Heap;

public class HeapDemo {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        heap.insert(15);
        System.out.println(heap);
    }
}
