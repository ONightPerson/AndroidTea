package com.liubz.androidtea.cherish.datastructure.linkedlist;

import com.liubz.androidtea.cherish.datastructure.bean.Node;
import com.liubz.androidtea.cherish.utils.LinkedListUtils;

public class InsertInSortedLinkedList {
    public static void main(String[] args) {
        Node<Integer> head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(12);

        Node<Integer> head = insert(head1, new Node<Integer>(6));
        LinkedListUtils.print(head);

        Node<Integer> removedHead = remove(head, 12);
        LinkedListUtils.print(removedHead);

    }

    static Node<Integer> insert(Node<Integer> head, Node<Integer> n) {
        if (head == null) {
            return n;
        }
        Node<Integer> dummy = new Node<Integer>(-1);
        dummy.next = head;
        Node<Integer> p = dummy;
        while(p.next != null) {
            if (p.next.data > n.data) {
                n.next = p.next;
                p.next = n;
                break;
            }
            p = p.next;
        }
        return dummy.next;
    }

    /**
     * 移除值为data的第一个节点
     * @param head
     * @param data
     * @return
     */
    static Node<Integer> remove(Node<Integer> head, int data) {
        Node<Integer> dummy = new Node<>(-1);
        dummy.next = head;
        Node<Integer> p = dummy;
        while(p.next != null) {
            if (p.next.data == data) {
                Node<Integer> temp = p.next;
                p.next = p.next.next;
                temp.next = null;
                break;
            }
            p = p.next;

        }
        return dummy.next;
    }
}
