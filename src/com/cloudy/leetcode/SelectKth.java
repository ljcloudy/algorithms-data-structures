package com.cloudy.leetcode;

class SelectKth {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
//        int[] nums = {2,1};
        int k = 2;

        SelectKth selectKth = new SelectKth();
        int kthLargest = selectKth.findKthLargest(nums, k);
        System.out.println("result : " + kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k + 1;

        return solve(nums, 0, nums.length - 1, k - 1);
    }

    public int solve(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        int p = partition(nums, l, r);
        if (k == p) {
            return nums[p];
        } else if (k < p) {//如果k<p,只需要在array[l,p-1]中找第k小元素。
            return solve(nums, l, p - 1, k);
        } else {//// 如果 k > p, 则需要在array[p+1...r]中找第k-p-1小元素
            // 注意: 由于我们传入__selection的依然是array, 而不是array[p+1...r],
            //       所以传入的最后一个参数依然是k, 而不是k-p-1
            return solve(nums, p + 1, r, k);
        }
    }

    public int partition(int[] nums, int l, int r) {
        // swap(nums, l, (int) (Math.random() * (r - l + 1)) + l);
        int v = nums[l];
        int j = l; // 维持 [l+1,j] < v <[j+1,r]
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < v) {
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, j, l);
        return j;
    }

    public int findKthLargest2(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length - 1);
    }

    // quick select to find the kth-largest element
    public int quickSelect(int[] arr, int k, int left, int right) {
        if (left == right)
            return arr[right];

        //patition方法还是用的 快排中的 partition
        int index = partition(arr, left, right);

        if (index - left + 1 > k)
            return quickSelect(arr, k, left, index - 1);
        else if (index - left + 1 == k)
            return arr[index];
        else
            return quickSelect(arr, k - index + left - 1, index + 1, right);

    }


    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}