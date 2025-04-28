package com.liubz.androidtea.cherish.datastructure.bean;

/**
 * 大顶堆
 */
public class Heap {
    private int[] heap; // 堆的底层存储结构
    private int capacity;   // 堆的最大容量
    private int count; // 堆中已经存储的元素数量

    public Heap(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.heap = new int[capacity];
    }

    public boolean insert(int value) {
        if (count == capacity) {
            return false;
        }
        int index = count;
        if (index == 0) {
            heap[0] = value;
        } else {
            siftUp(index, value);
        }
        count = index + 1;
        return true;
    }

    /**
     * 获取对顶元素
     * @return
     */
    public int take() {
        int result = heap[0];
        count--;
        heap[0] = heap[count];
        siftDown(0, heap[0]);
        return result;
    }

    private void siftUp(int i, int value) {
        while (i > 0) {
            int parent = (i - 1) >>> 1;
            if (heap[parent] >= value) {
                break;
            }
            heap[i] = heap[parent];
            i = parent;
        }
        heap[i] = value;
    }

    public void siftDown(int i, int value) {
        int half = count >>> 1;
        while (i < half) {
            int child = 2 * i + 1;
            int right = child + 1;
            if (right < count && heap[right] > heap[child]) {
                child = right;
            }
            if (value >= heap[child]) {
                break;
            }
            heap[i] = heap[child];
            i = child;
        }
        heap[i] = value;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(heap[i]).append(" ");
        }
        return sb.toString();
    }
}
