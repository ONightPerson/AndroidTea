package com.liubz.androidtea.cherish.tools;

/**
 * Created by liubaozhu on 2020/12/21
 */
public class Test {

    public static void main(String[] args) {
        try {
            assert 9 == getSumDigitsOfNum(153);
            assert 0 == getSumDigitsOfNum(0);
            assert 1 == getSumDigitsOfNum(10);
            assert(2 == getSumDigitsOfNum(100000));
            System.out.println("hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int getSumDigitsOfNum(int num) throws Exception {
        if (num < 0) {
            throw new Exception("数值不合法，请传入正整数");
        }
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
