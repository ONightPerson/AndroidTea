package com.liubz.androidtea.cherish;

public class Exerciser {

    public static void main(String[] args) {
//        int result = divide(12, -2);
//        System.out.println(result);
        // 几乎都是$JAVA_HONE/jre/lib目录下的jar包
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
        ClassLoader loader = Exerciser.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.getClass().getName());
            loader = loader.getParent();
        }
    }

    /**
     * 手写一个除法
     */
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("除数不能为0");
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            } else if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        boolean negative = (dividend > 0) ^ (divisor > 0);
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);

        long left = 0;
        long right = lDividend;
        long result = 0;
        while (left <= right) {
            long mid = left + ((right - left) >> 1);
            long product = mid * lDivisor;
            if (product <= lDividend) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return negative ? (int) -result : (int) result;
    }
}
