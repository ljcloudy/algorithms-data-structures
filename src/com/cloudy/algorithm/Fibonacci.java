package com.cloudy.algorithm;

/**
 * 斐波那契数列解法：
 * 1.递归  O(2^n)
 * 2.循环  O(n)
 * 3.矩阵  O(logn)
 * created by lijianyun on 2018/9/21
 */
public class Fibonacci {

    public static int sovle(int i) {
        assert i >= 0;
        if (i == 1 || i == 2) {
            return 1;
        }
        return sovle(i - 1) + sovle(i - 2);
    }

    public static int sovle2(int i) {
        assert i >= 0;

        int f0 = 1;
        int f1 = 1;
        if (i == 1 || i == 2) {
            return f1;
        }
        int f2 = 0;
        for (int j = 2; j < i; j++) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }


    public static void main(String[] args) {

        int n = 44;
        long start = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            int sovle = sovle(i);
            if (i == n) {
                System.out.println(sovle);
            }
        }
        System.out.println("sovle : " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            int sovle = sovle2(i);
            if (i == n) {
                System.out.println(sovle);
            }
        }

        System.out.println("sovle2 : " + (System.currentTimeMillis() - start));
    }
}
