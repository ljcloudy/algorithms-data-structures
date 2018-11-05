package com.cloudy.algorithm.math;

/**
 * Created by ljy_cloudy on 2018/11/3.
 */
public class Prime {


    public static void main(String[] args) {

        System.out.println(Math.sqrt(27));
        for (int i = 1; i < 10; i++) {
            boolean b = isPrime4(i);
            System.out.println(i + " 是素数吗：" + b);
        }
    }

    /**
     * 暴力解法
     * 时间复杂度为 n/2
     *
     * @param n
     * @return
     */
    public static boolean isPrime1(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("非法参数：" + n);
        }
        if (n == 1 || n == 2) {
            return true;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 假如n 为合数，必然存在两个数p1*p2=n,其中p1<=sqrt(n), p2>=sqrt(n)
     * 根据以上减少循环次数
     *
     * @param n
     * @return
     */
    public static boolean isPrime2(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("非法参数：" + n);
        }
        if (n == 1 || n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param n
     * @return
     */
    public static boolean isPrime3(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("非法参数：" + n);
        }
        if (n == 1 || n == 2) {
            return true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 排除已有素数的倍数
     *
     * @param n
     * @return
     */
    public static boolean isPrime4(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("非法参数：" + n);
        }
        if (n <= 3)
            return true;
        else if (((n & 1) == 0) || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }
}
