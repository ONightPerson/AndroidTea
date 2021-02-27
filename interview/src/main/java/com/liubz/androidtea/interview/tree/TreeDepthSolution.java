package com.liubz.androidtea.interview.tree;

/**
 * author: created by liubaozhu on 2021/2/27
 * email: liubaozhu@baidu.com
 */
public class TreeDepthSolution {

    private int mTreeDepth = 0;

    public static void main(String[] args) {
       BinaryTreeNode<Integer> root = TreeUtils.createBinaryTree();

        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.setRoot(root);
        System.out.println("tree depth: " + tree.getDepth());
//        TreeDepthSolution solution = new TreeDepthSolution();
//        solution.calTreeDepth(root);
//        System.out.println("tree depth: " + solution.getTreeDepth());
    }

    public void calTreeDepth(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        int depth = 0;
        dfs(root, depth);
    }

    private void dfs(BinaryTreeNode<Integer> node, int depth) {
        if (node == null) {
            if (mTreeDepth < depth) {
                mTreeDepth = depth;
            }
            return;
        }
        dfs(node.getLeftChild(), depth + 1);
        dfs(node.getRightChild(), depth + 1);
    }

    public int getTreeDepth() {
        return mTreeDepth;
    }

}
