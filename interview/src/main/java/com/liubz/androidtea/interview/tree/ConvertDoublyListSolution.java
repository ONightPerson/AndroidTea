package com.liubz.androidtea.interview.tree;

/**
 * author: created by liubaozhu on 2021/2/27
 * email: liubaozhu@baidu.com
 */
public class ConvertDoublyListSolution {

    private BinaryTreeNode<Integer> mHead;
    private BinaryTreeNode<Integer> mPre;

    public static void main(String[] args) {
        int[] preOrder = {15, 13, 7, 8, 14, 17, 16, 19, 18};
        int[] inOrder = {7, 8, 13, 14, 15, 16, 17, 18, 19};
        BinaryTreeNode<Integer> main = null;
        try {
            main = RebuildBinaryTree.rebuildBinaryTree(preOrder, inOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ConvertDoublyListSolution solution = new ConvertDoublyListSolution();
        BinaryTreeNode<Integer> head = solution.treeToDoublyList(main);
        BinaryTreeNode<Integer> p = head;
        while (p != null) {
            System.out.print(p.getData() + " ");
            p = p.getRightChild();
        }
        System.out.println();
    }

    public BinaryTreeNode<Integer> treeToDoublyList(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        mHead.setLeftChild(mPre);
        mPre.setRightChild(mHead);

        return mHead;
    }

    private void dfs(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return;
        }
        dfs(node.getLeftChild());
        if (mPre == null) {
            mHead = node;
        } else {
            mPre.setRightChild(node);
        }
        node.setLeftChild(mPre);
        mPre = node;
        dfs(node.getRightChild());
    }


}
