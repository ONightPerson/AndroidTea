package com.liubz.androidtea.cherish.datastructure.stack;

/**
 * 顺序栈实现
 * @param <T>
 */
public class ArrayStack<T> {
    private Object[] items;
    private int count; // 栈中元素数
    private int capacity; // 栈大小

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        items = new Object[capacity];
        count = 0;
    }

    public boolean push(T item) {
        if (count == capacity) {
            return false;
        }
        items[count++] = item;
        return true;
    }

    public T pop() {
        if (count == 0) {
            return null;
        }
        return (T) items[--count];
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayStack [");
        for (int i = 0; i < count; i++) {
            sb.append(items[i]);
            if (i != count - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
