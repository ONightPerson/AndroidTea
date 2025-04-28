package com.liubz.androidtea.cherish.datastructure.tree;

import com.liubz.androidtea.cherish.datastructure.bean.TreeNode;

public class BinarySearchTree {
    private TreeNode root;

    public TreeNode find(int target) {
        TreeNode p = root;
        while (p != null) {
            if (p.val == target) {
                return p;
            } else if (p.val > target) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    public void insert(int target) {
        if (root == null) {
            root = new TreeNode(target);
            return;
        }
        TreeNode p = root;
        while (p != null) {
            if (target < p.val) {
                if (p.left == null) {
                    p.left = new TreeNode(target);
                    return;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new TreeNode(target);
                    return;
                }
                p = p.right;
            }
        }
    }

    /**
     *          15
     *      8           25
     *   6     9     22    28
     * 1  7   11 13  16 23
     *
     *
     *
     * @param target
     */
    public void delete(int target) {

    }
}
