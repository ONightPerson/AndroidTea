package com.liubz.androidtea.cherish.datastructure.stack;

import java.util.LinkedList;
import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
//      testLinkedStack();
//        String s = "()";
//        System.out.println(isValidString(s));
//        String s1 = "{sss}{2}(2)";
//        System.out.println(isValidString(s1));
//        String s2 = "{sss}{2}(2)}";
//        System.out.println(isValidString(s2));

        String s3 = "()()(()";
        System.out.println(longestValidParentheses(s3));
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
     *
     * ()(()
     * ()()(()
     * 分析
     * ()(()
     * -1 maxLen = 2
     * -1 2 maxLen = 2;
     *
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
}
