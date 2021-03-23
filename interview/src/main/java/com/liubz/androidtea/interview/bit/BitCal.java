package com.liubz.androidtea.interview.bit;

/**
 * author: created by liubaozhu on 2021/3/2
 * email: liubaozhu@baidu.com
 */
public class BitCal {

    /**
     * 获取整数中 1 出现的次数
     * @param n
     * @return
     */
    public static int getOneFrequency(int n) {
        int count = 0;
        int flag = 1;
        while (flag > 0) {
            int result = n & flag;
            if (result > 0) {
                count++;
            }
            flag <<= 1;
        }
        return count;
    }

    public static int getOneFrequency2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n-1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        long curTime = System.nanoTime();
        int number = getOneFrequency2(Integer.MAX_VALUE);
        System.out.println("consume time: " + (System.nanoTime() - curTime));
    }
}
