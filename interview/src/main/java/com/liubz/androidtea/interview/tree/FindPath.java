package com.liubz.androidtea.interview.tree;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * author: created by liubaozhu on 2021/2/25
 * email: liubaozhu@baidu.com
 */
public class FindPath {

    /**
     *       4
     *     7   9
     *   6  3   8
     *       5
     *
     * @param args
     */

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
        findPath(main, 17);
    }

    public static void findPath(BinaryTreeNode<Integer> root, int expected) {
        if (root == null) {
            return;
        }
        int sum = 0;
        LinkedList<Integer> path = new LinkedList<>();
        findPath(root, expected, sum, path);
    }

    private static void findPath(BinaryTreeNode<Integer> node, int expected, int sum,
                                 LinkedList<Integer> path) {
        // 当前没到叶子节点，则累加当前节点值
        int value = node.getData();
        path.push(value);
        sum += value;
        boolean isLeaf = node.getLeftChild() == null && node.getRightChild() == null;
        if (isLeaf) {
            if (sum == expected) {
                // 找到一条路径
                Iterator<Integer> iter = path.descendingIterator();
                while (iter.hasNext()) {
                    System.out.print(iter.next() + " ");
                }
                System.out.println();
            }
            return;
        }

        if (node.getLeftChild() != null) {
            findPath(node.getLeftChild(), expected, sum, path);
        }
        if (node.getRightChild() != null) {
            findPath(node.getRightChild(), expected, sum, path);
        }
        path.poll();
    }
}
