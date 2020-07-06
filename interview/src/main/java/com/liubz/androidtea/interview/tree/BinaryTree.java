package com.liubz.androidtea.interview.tree;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {

    private BinaryTreeNode<T> mRoot; // 根节点

    public BinaryTree() {

    }

    public BinaryTree(BinaryTreeNode<T> root) {
        mRoot = root;
    }

    public BinaryTreeNode<T> getRoot() {
        return mRoot;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        mRoot = root;
    }

    public void addLeftChild(BinaryTreeNode<T> leftChild) {
        checkTreeEmpty();
        mRoot.setLeftChild(leftChild);
    }

    public void addRightChild(BinaryTreeNode<T> rightChild) {
        checkTreeEmpty();
        mRoot.setRightChild(rightChild);
    }

    public void checkTreeEmpty() {
        if (mRoot == null) {
            throw new IllegalStateException("can't insert to a null tree, please check!");
        }
    }

    /**
     * 前序遍历
     */
    public void preOrderTraverse() {
        if (mRoot == null) {
            System.out.println("Tree is empty.");
        }

        doPreOrderTraverse(mRoot);
    }

    /**
     * 中序遍历
     */
    public void inOrderTraverse() {
        if (mRoot == null) {
            System.out.println("Tree is empty.");
        }

        doInOrderTraverse(mRoot);
    }

    /**
     * 后续遍历
     */
    public void postOrderTraverse() {
        if (mRoot == null) {
            System.out.println("Tree is empty.");
        }

        doPostOrderTraverse(mRoot);
    }

    /**
     * 层序遍历（队列实现）
     */
    public void levelOrderTraverse() {
        if (mRoot == null) {
            System.out.println("Tree is empty.");
        }
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(mRoot); // same as add

        int curNodeCount = 1;
        int increCount = 0;
        int level = 0;
        int changeLevel = 1;
        while (!queue.isEmpty()) {
            if (changeLevel != level) {
                System.out.println("--------层级" + changeLevel + "--------");
                level = changeLevel;
            }

            BinaryTreeNode<T> node = queue.poll();
            visit(node);
            curNodeCount--;
            BinaryTreeNode<T> leftChild = node.getLeftChild();
            BinaryTreeNode<T> rightChild = node.getRightChild();
            if (leftChild != null) {
                queue.offer(leftChild);
                increCount++;
            }
            if (rightChild != null) {
                queue.offer(rightChild);
                increCount++;
            }

            if (curNodeCount == 0) {
                System.out.println();
                curNodeCount = increCount;
                increCount = 0;
                changeLevel++;
            }

        }


    }

    private void doPostOrderTraverse(BinaryTreeNode<T> tNode) {
        if (tNode != null) {
            doPostOrderTraverse(tNode.getLeftChild());
            doPostOrderTraverse(tNode.getRightChild());
            visit(tNode);
        }
    }

    private void doPreOrderTraverse(BinaryTreeNode<T> tNode) {
        if (tNode != null) {
            visit(tNode);
            doPreOrderTraverse(tNode.getLeftChild());
            doPreOrderTraverse(tNode.getRightChild());
        }
    }

    private void doInOrderTraverse(BinaryTreeNode<T> tNode) {
        if (tNode != null) {
            System.out.print("(");
            doInOrderTraverse(tNode.getLeftChild());
            visit(tNode);
            doInOrderTraverse(tNode.getRightChild());
            System.out.print(")");
        }
    }

    private void visit(BinaryTreeNode<T> tNode) {
        System.out.print(tNode.getData());
    }
}
