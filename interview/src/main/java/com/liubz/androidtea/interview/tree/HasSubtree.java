package com.liubz.androidtea.interview.tree;

/**
 * author: created by liubaozhu on 2021/2/24
 * email: liubaozhu@baidu.com
 */
public class HasSubtree {

    public static boolean hasSubtree(BinaryTreeNode<Integer> main, BinaryTreeNode<Integer> sub) {
        boolean result = false;
        if (main.getData() == sub.getData()) {
            result = checkHasSubtree(main, sub);
        }
        if (!result) {
            result = checkHasSubtree(main.getLeftChild(), sub);
        }
        if (!result) {
            result = checkHasSubtree(main.getRightChild(), sub);
        }
        return result;
    }

    public static boolean checkHasSubtree(BinaryTreeNode<Integer> main,
                                          BinaryTreeNode<Integer> sub) {
        if (sub == null) {
            return true;
        }
        if (main == null) {
            return false;
        }
        if (main.getData() != sub.getData()) {
            return false;
        }

        return checkHasSubtree(main.getLeftChild(), sub.getLeftChild())
                && checkHasSubtree(main.getRightChild(), sub.getRightChild());
    }



    public static void main(String[] args) {
        // 创建主树
        int[] preOrder = {4, 7, 6, 3, 5, 9, 8};
        int[] inOrder = {6, 7, 5, 3, 4, 9, 8};
        BinaryTreeNode<Integer> main = null;
        try {
            main = RebuildBinaryTree.rebuildBinaryTree(preOrder, inOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int[] subPreOrder = {7, 6, 3};
        int[] subInOrder = {6, 7, 3};
        BinaryTreeNode<Integer> sub = null;
        try {
            sub = RebuildBinaryTree.rebuildBinaryTree(subPreOrder, subInOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean hasSubtree = hasSubtree(main, sub);
        System.out.println("has subtree: " + hasSubtree);
    }
}
