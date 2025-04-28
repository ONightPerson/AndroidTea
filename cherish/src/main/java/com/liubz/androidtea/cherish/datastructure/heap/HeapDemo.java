package com.liubz.androidtea.cherish.datastructure.heap;

import com.liubz.androidtea.cherish.datastructure.bean.Heap;

public class HeapDemo {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        heap.insert(15);
        heap.insert(5);
        heap.insert(18);
        System.out.println(heap);

        System.out.println("获取对顶元素：" + heap.take());
        System.out.println(heap);
    }
}
