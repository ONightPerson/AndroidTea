package com.liubz.androidtea.interview.tree;

public class BinaryTreeNode<T> {

    private T mData;
    private BinaryTreeNode<T> mLeftChild;
    private BinaryTreeNode<T> mRightChild;

    public BinaryTreeNode(T data) {
        mData = data;
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
        mData = data;
        mLeftChild = leftChild;
        mRightChild = rightChild;
    }

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        mData = data;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return mLeftChild;
    }

    public void setLeftChild(BinaryTreeNode<T> leftChild) {
        mLeftChild = leftChild;
    }

    public BinaryTreeNode<T> getRightChild() {
        return mRightChild;
    }

    public void setRightChild(BinaryTreeNode<T> rightChild) {
        mRightChild = rightChild;
    }
}
