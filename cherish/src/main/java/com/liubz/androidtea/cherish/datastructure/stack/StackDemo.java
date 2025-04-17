package com.liubz.androidtea.cherish.datastructure.stack;

import com.liubz.androidtea.cherish.datastructure.bean.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class StackDemo {

    public static void main(String[] args) {
//      testLinkedStack();
//        String s = "()";
//        System.out.println(isValidString(s));
//        String s1 = "{sss}{2}(2)";
//        System.out.println(isValidString(s1));
//        String s2 = "{sss}{2}(2)}";
//        System.out.println(isValidString(s2));

//        String s3 = "()()(()";
//        System.out.println(longestValidParentheses(s3));

//        simplifyPath2("/.../a/../b/c/../d/./");
    }

    public static void testArrayStack() {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack);
        System.out.println(stack.pop());
    }

    public static void testLinkedStack() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }

    public static boolean isValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        LinkedList<Character> stack = new LinkedList<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                default:
                    break;

            }
        }
        return stack.isEmpty();
    }

    /**
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * (()()
     * 思路：设置最长有效子串长度为0，遍历字符串，每遍历一个字符，计数一次，当出现符号无法匹配时，则计数结束，与已有最长子串长度比较并更新，并重新计数
     * <p>
     * ()(()
     * ()()(()
     * 分析
     * ()(()
     * -1 maxLen = 2
     * -1 2 maxLen = 2;
     * <p>
     * ()()(()
     * -1
     */
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());

                }
            }
        }
        return maxLen;
    }

    /**
     * 71. 简化路径
     * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为 更加简洁的规范路径。
     * <p>
     * 在 Unix 风格的文件系统中规则如下：
     * <p>
     * 一个点 '.' 表示当前目录本身。
     * 此外，两个点 '..' 表示将目录切换到上一级（指向父目录）。
     * 任意多个连续的斜杠（即，'//' 或 '///'）都被视为单个斜杠 '/'。
     * 任何其他格式的点（例如，'...' 或 '....'）均被视为有效的文件/目录名称。
     * 返回的 简化路径 必须遵循下述格式：
     * <p>
     * 始终以斜杠 '/' 开头。
     * 两个目录名之间必须只有一个斜杠 '/' 。
     * 最后一个目录名（如果存在）不能 以 '/' 结尾。
     * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
     * 返回简化后得到的 规范路径 。
     * <p>
     * 提示：
     * <p>
     * 1 <= path.length <= 3000
     * path 由英文字母，数字，'.'，'/' 或 '_' 组成。
     * path 是一个有效的 Unix 风格绝对路径。
     */

    public static String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }
        ArrayDeque<String> deque = new ArrayDeque<>();
        String[] split = path.split("/");
        for (String s : split) {
            if (s.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pop();
                }
            } else if (s.equals(".") || s.equals("")) {

            } else {
                deque.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            String item = deque.pollFirst();
            sb.append("/").append(item);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     * <p>
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     */
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> preOrderList = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            preOrderList.add(node);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        int n = preOrderList.size();
        preOrderList.get(n - 1).left = null;
        preOrderList.get(n - 1).right = null;
        for (int i = 0; i < n - 1; i++) {
            TreeNode cur = preOrderList.get(i), next = preOrderList.get(i + 1);
            cur.left = null;
            cur.right = next;
        }
    }
}
