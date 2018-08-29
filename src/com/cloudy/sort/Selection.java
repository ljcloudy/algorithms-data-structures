package com.cloudy.sort;

/**
 * 查找数组中第k大的元素
 * 利用快速排序的思想，每次partition都能确定该数的位置
 * created by lijianyun on 2018/8/28
 */
public class Selection {

    public static int solve2(int[] array, int k){
        return solve(array,0,array.length-1, k-1);
    }

    public static int solve(int[] array, int k) {
        assert k >= 0 && k < array.length;

        return solve(array, 0, array.length - 1, k);
    }
    // 寻找nums数组中第k小的元素
    // 注意: 在我们的算法中, k是从0开始索引的, 即最小的元素是第0小元素, 以此类推
    // 如果希望我们的算法中k的语意是从1开始的, 只需要在整个逻辑开始进行k--即可, 可以参考solve2
    private static int solve(int[] array, int l, int r, int k) {

        if (l == r) {
            return array[l];
        }
        int p = partition(array, l, r);
        if (k == p) {
            return array[p];
        } else if (k < p) {//如果k<p,只需要在array[l,p-1]中找第k小元素。
            return solve(array, l, p - 1, k);
        } else {//// 如果 k > p, 则需要在array[p+1...r]中找第k-p-1小元素
            // 注意: 由于我们传入__selection的依然是array, 而不是array[p+1...r],
            //       所以传入的最后一个参数依然是k, 而不是k-p-1
            return solve(array, p + 1, r, k);
        }
    }

    private static int partition(int[] array, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(array, l, (int) (Math.random() * (r - l + 1)) + l);

        int v = array[l];

        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = l + 1; i <= r; i++)
            if (array[i] < v) {
                j++;
                swap(array, j, i);
            }

        swap(array, l, j);

        return j;
    }

    private static void swap(int[] array, int a, int b) {

        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int solve = Selection.solve2(array, 1);
        System.out.println(solve);
    }

}
