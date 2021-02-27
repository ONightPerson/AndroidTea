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
     * 前序遍历（递归）
     */
    public void preOrder() {
        checkTreeEmpty();

        doPreOrderTraverse(mRoot);
    }

    /**
     * 前序遍历（非递归）
     */
    public void preOrderNonRecursive() {
        checkTreeEmpty();
        LinkedList<BinaryTreeNode<T>> stack = new LinkedList<>();
        BinaryTreeNode<T> p = mRoot;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                visit(p);
                stack.push(p);
                p = p.getLeftChild();
            }
            if (!stack.isEmpty()) {
                BinaryTreeNode<T> node = stack.poll();
                p = node.getRightChild();
            }
        }
    }

    /**
     * 中序遍历（递归）
     */
    public void inOrder() {
        checkTreeEmpty();

        doInOrderTraverse(mRoot);
    }

    /**
     * 中序遍历（非递归）
     */
    public void inOrderNonRecursive() {
        checkTreeEmpty();

        LinkedList<BinaryTreeNode<T>> stack = new LinkedList<>();
        BinaryTreeNode<T> p = mRoot;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.getLeftChild();
            }
            if (!stack.isEmpty()) {
                BinaryTreeNode<T> node = stack.poll();
                visit(node);
                p = node.getRightChild();
            }
        }
    }

    /**
     * 后序遍历（递归）
     */
    public void postOrder() {
        checkTreeEmpty();

        doPostOrderTraverse(mRoot);
    }

    /**
     * 中序遍历（非递归）
     */
    public void postOrderNonRecursive() {
        checkTreeEmpty();

        LinkedList<BinaryTreeNode<T>> stack = new LinkedList<>();
        stack.push(mRoot);
        BinaryTreeNode<T> pre = null;
        while (!stack.isEmpty()) {
            BinaryTreeNode<T> cur = stack.peek();
            if ((cur.getLeftChild() == null && cur.getLeftChild() == null) ||
                    (pre != null && pre == cur.getLeftChild() || pre == cur.getRightChild())) {
                visit(cur);
                stack.poll();
                pre = cur;
            } else {
                BinaryTreeNode<T> rChild = cur.getRightChild();
                if (rChild != null) {
                    stack.push(rChild);
                }
                BinaryTreeNode<T> lChild = cur.getLeftChild();
                if (lChild != null) {
                    stack.push(lChild);
                }
            }
        }
    }

    /**
     * 层序遍历（队列实现）
     */
    public void levelOrder() {
        checkTreeEmpty();
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

    /**
     * 获取树的深度
     * @return 树深度
     */
    public int getDepth() {
        return getDepth(mRoot);
    }

    private int getDepth(BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        int leftChildDepth = getDepth(node.getLeftChild());
        int rightChildDepth = getDepth(node.getRightChild());
        return leftChildDepth > rightChildDepth ? leftChildDepth + 1 : rightChildDepth + 1;
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
            doInOrderTraverse(tNode.getLeftChild());
            visit(tNode);
            doInOrderTraverse(tNode.getRightChild());
        }
    }

    private void visit(BinaryTreeNode<T> tNode) {
        System.out.print(tNode.getData() + " ");
    }
}
