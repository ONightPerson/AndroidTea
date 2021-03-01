package com.liubz.androidtea.interview.loop;

/**
 * author: created by liubaozhu on 2021/3/2
 * email: liubaozhu@baidu.com
 */
public class Fibonacci {


    public static long fibonacci(int n) throws Exception {
        if (n < 0) {
            throw new Exception("invalid params");
        }
        int[] result = {0, 1};
        if (n <= 2) {
            return result[n];
        }
        long lower = 0;
        long bigger = 1;
        long fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = lower + bigger;
            lower = bigger;
            bigger = fibN;
        }
        return fibN;
    }

    public static void main(String[] args) throws Exception {
        long fib = fibonacci(165);
        System.out.println("fib: " + fib);
    }
}
