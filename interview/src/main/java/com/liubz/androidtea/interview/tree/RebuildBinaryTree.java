package com.liubz.androidtea.interview.tree;

/**
 * 根据前序和中序遍历序列，重建二叉树
 * author: created by liubaozhu on 2021/2/24
 * email: liubaozhu@baidu.com
 */
public class RebuildBinaryTree {

    public static BinaryTreeNode<Integer> rebuildBinaryTree(int[] preOrder, int[] inOrder) throws Exception {
        if (preOrder == null || inOrder == null) {
            return null;
        }
        int m = preOrder.length;
        int n = inOrder.length;
        if (m != n || m <= 0) {
            return null;
        }
        return doRebuildBinaryTree(preOrder, 0, n - 1, inOrder, 0, n - 1);
    }

    public static BinaryTreeNode<Integer> doRebuildBinaryTree(
            int[] preOrder, int startPreOrder, int endPreOrder,
            int[] inOrder, int startInOrder, int endInOrder) throws Exception {
        int rootValue = preOrder[startPreOrder];
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(rootValue);
        rootNode.setLeftChild(null);
        rootNode.setRightChild(null);
        if (startPreOrder == endPreOrder) {
            if (startInOrder == endInOrder && inOrder[startInOrder] == preOrder[startPreOrder]) {
                return rootNode;
            } else {
                throw new Exception("invalid input");
            }
        }

        int rootInOrder = startInOrder;
        while (rootInOrder <= endInOrder && inOrder[rootInOrder] != rootValue) {
            rootInOrder++;
        }
        if (rootInOrder > endInOrder) {
            throw new Exception("invalid input");
        }
        int leftLength = rootInOrder - startInOrder;
        int rightLength = endInOrder - rootInOrder;
        if (leftLength > 0) {
            BinaryTreeNode<Integer> leftChild = doRebuildBinaryTree(
                    preOrder, startPreOrder + 1, startPreOrder + leftLength,
                    inOrder, startInOrder, rootInOrder - 1);
            rootNode.setLeftChild(leftChild);
        }
        if (rightLength > 0) {
            BinaryTreeNode<Integer> rightChild = doRebuildBinaryTree(
                    preOrder, startPreOrder + leftLength + 1, endPreOrder,
                    inOrder, rootInOrder + 1, endInOrder);
            rootNode.setRightChild(rightChild);
        }
        return rootNode;
    }

    public static void main(String[] args) {
        int[] preOrder = {4, 7, 6, 3, 5, 9, 8};
        int[] inOrder = {6, 7, 5, 3, 4, 9, 8};
        BinaryTreeNode<Integer> root = null;
        try {
            root = rebuildBinaryTree(preOrder, inOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BinaryTree<Integer> tree = new BinaryTree<>(root);
        tree.preOrder();
        System.out.println();
        tree.inOrder();
    }


}
