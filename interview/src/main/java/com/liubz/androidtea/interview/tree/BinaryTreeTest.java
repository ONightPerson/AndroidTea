package com.liubz.androidtea.interview.tree;

/**
 * author: created by liubaozhu on 2020-02-09
 * email: liubaozhu@baidu.com
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTreeNode<String> root = new BinaryTreeNode("+");
        BinaryTree<String> tree = new BinaryTree(root);
        BinaryTreeNode<String> leftChild = new BinaryTreeNode<>("+");
        BinaryTreeNode<String> rightChild = new BinaryTreeNode<>("d");
        // 添加根节点的孩子结点
        tree.addLeftChild(leftChild);
        tree.addRightChild(rightChild);

        // 添加二级结点的孩子结点
        BinaryTreeNode<String> leftChild1 = new BinaryTreeNode<>("+");
        leftChild.setLeftChild(leftChild1);
        leftChild.setRightChild(new BinaryTreeNode<>("c"));

        // 添加 3级级结点的孩子结点
        leftChild1.setLeftChild(new BinaryTreeNode<>("a"));
        leftChild1.setRightChild(new BinaryTreeNode<>("b"));

        tree.preOrderTraverse();
        System.out.println();
        tree.inOrderTraverse();
        System.out.println();
        tree.postOrderTraverse();
        System.out.println();
        tree.levelOrderTraverse();
    }

}
