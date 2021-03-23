package com.liubz.androidtea.interview;

/**
 * author: created by liubaozhu on 2021/3/4
 * email: liubaozhu@baidu.com
 */
public class PrintOneToMax {

    public static void printOneToMax(int n) {
        if (n <= 0) {
            return;
        }
        char[] numbers = new char[n];
        for (int i = 0; i < 10; i++) {
            printOneToMaxRecursively(numbers, numbers.length, 0);
        }
    }

    private static void printOneToMaxRecursively(char[] numbers, int length, int index) {
        if (index == length - 1) {
            printNumber(numbers);
            return;
        }
        for (int i = 0; i < 10; i++) {
            numbers[index + 1] = (char) i;
            printOneToMaxRecursively(numbers, length, index + 1);
        }
    }

    private static void printNumber(char[] numbers) {
        boolean isZeroPre = true;
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            if (isZeroPre && numbers[i] != 0) {
                isZeroPre = false;
            }
            if (!isZeroPre) {
                System.out.print((int)numbers[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printOneToMax(5);
    }
}
