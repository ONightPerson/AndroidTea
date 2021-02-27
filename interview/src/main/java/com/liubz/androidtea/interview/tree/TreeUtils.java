package com.liubz.androidtea.interview.tree;

/**
 * author: created by liubaozhu on 2021/2/27
 * email: liubaozhu@baidu.com
 */
public class TreeUtils {


    /**
     *                15
     *             13    17
     *            7  14 16  19
     *             8       18
     *              12
     * @return
     */
    public static BinaryTreeNode<Integer> createBinaryTree() {
        int[] preOrder = {15, 13, 7, 8, 12, 14, 17, 16, 19, 18};
        int[] inOrder = {7, 8, 12, 13, 14, 15, 16, 17, 18, 19};
        BinaryTreeNode<Integer> main = null;
        try {
            main = RebuildBinaryTree.rebuildBinaryTree(preOrder, inOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return main;
    }
}
