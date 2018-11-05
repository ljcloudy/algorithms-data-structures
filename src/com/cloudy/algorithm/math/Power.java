package com.cloudy.algorithm.math;

/**
 * Created by ljy_cloudy on 2018/11/4.
 */
public class Power {

    public static void main(String[] args) {
        System.out.println(pow(2, -2));
    }

    /**
     * 计算x的n次方 时间复杂度：O(log(n))
     *
     * @param x
     * @param n
     * @return
     */
    public static double pow(double x, int n) {

        if (n == 0)
            return 1.0;
        double t = pow(x, n / 2);
        if (n % 2 == 0)
            return t * t;
        else if (n > 0)
            return x * t * t;
        else
            return t * t / x;
    }
}
