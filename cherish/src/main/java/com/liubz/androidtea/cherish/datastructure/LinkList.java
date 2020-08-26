package com.liubz.androidtea.cherish.datastructure;

/**
 * Created by liubaozhu on 2020/8/10
 */
public class LinkList {

    public static Node createLinkList() {
        Node head = new Node(3);

        Node node = new Node(1);
        head.next = node;

        Node node1 = new Node(1);
        node.next = node1;

        Node node2 = new Node(3);
        node1.next = node2;
//        node2.next = new Node(3);

        return head;
    }

    public static void main(String[] args) {
//        Node head = createLinkList();
//        Node center = findCenterNode(head);
//        Node reverseNode = reverseLinkList(center.next);
//        Node p = head;
//        boolean ishuiwen = true;
//        while (reverseNode != null) {
//            if (reverseNode.data != p.data) {
//                ishuiwen = false;
//                break;
//            }
//            reverseNode = reverseNode.next;
//            p = p.next;
//        }
//        System.out.println("是否为回文链表: " + ishuiwen);

        for (int i = 0; i <= 10; i++)
            System.out.print(fibonaci(i) + ", ");


    }

    /**
     * 寻找中心节点
     * @param head 头结点
     * @return
     */
    public static Node findCenterNode(Node head) {
        // 处理链空和单节点
        if (head == null || head.next == null) {
            return head;
        }

        Node q = head;
        Node s = head;

        while (q.next != null && q.next.next != null) {
            s = s.next;
            q = q.next.next;
        }

        return s;
    }

    /**
     * 翻转节点
     * @return
     */
    public static Node reverseLinkList(Node head) {
        if (head == null) {
            return null;
        }

        Node p = head;
        Node dummy = new Node(-1);
        Node n;
        while (p != null) {
            n = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = n;
        }

        return dummy.next;
    }

    /**
     * 非递归
     *          0, n=0;
     * f(n) =   1, n=1;
     *          f(n-1)+f(n-2) n>=2;
     * @param n
     * @return
     */
    public static int fibonaci(int n) {
        if (n < 2) {
            return n;
        }
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] += res[i-1] + res[i-2];
        }
        return res[n];
    }
}
