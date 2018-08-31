package com.cloudy.heap;

/**
 * created by lijianyun on 2018/8/30
 */
public class MaxHeap<T> {
    protected int[] data;

    protected int count;

    protected int capacity;

    public MaxHeap(int capacity) {
        data = new int[capacity + 1];
        this.capacity = capacity;
    }

    /**
     * 将一个数组初始化为最大堆
     * 将n个元素逐个插入到一个空堆中，算法时间复杂度为O(nlogn)
     * heapify的过程，算法复杂度为O(n)
     * @param array
     */
    public MaxHeap(int[] array) {
        data = new int[array.length + 1];
        capacity = array.length;
        for (int i = 0; i < array.length; i++) {
            data[i+1] = array[i];
        }
        count = array.length;
        for (int i = count/2; i >=1; i--) {
            shiftDown(i);
        }

    }

    /**
     * shift up
     *
     * @param item
     */
    public void insert(int item) {
        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    public int extracMax() {
        assert count > 0;
        int ret = data[1];
        swap(data, 1, count);
        count--;
        this.shiftDown(1);
        return ret;
    }

    /**
     * shift down 操作：
     *
     * @param k
     */
    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[j + 1] > data[j]) {
                j += 1;
            }
            if (data[k] >= data[j]) {
                break;
            }
            swap(data, k, j);
            k = j;
        }
    }

    private void shiftUp(int k) {
        while (k > 1 && data[k / 2] < data[k]) {
            swap(data, k / 2, k);
            k /= 2;
        }

    }

    private void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
