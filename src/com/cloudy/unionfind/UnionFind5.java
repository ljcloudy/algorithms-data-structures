package com.cloudy.unionfind;

/**
 * created by lijianyun on 2018/9/16
 */
public class UnionFind5 {
    //表示元素所指向的父节点
    private int[] parent;

    private int count;//数据个数
    private int[] rank;// rank[i]表示以i为根的集合所表示的树的层数

    public UnionFind5(int count) {
        parent = new int[count];
        rank = new int[count];
        this.count = count;
        //初始化，每个parent[i]指向自己，表示每个元素自己自成一个集合
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    /**
     * 查找过程，查找元素p所对应的集合编号
     * O(h)复杂度，h为树的高度
     *
     * @param p
     * @return
     */
    private int find(int p) {
        assert (p >= 0 && p < count);

//        while(p != parent[p]){
//            //路径压缩
//            parent[p] = parent[parent[p]];
//            p = parent[p];
//        }
//        return p;
        //路径压缩 递归算法
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    /**
     * 查找p和q是否所属一个集合
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q所属集合
     * 时间复杂度O(h),h为树的高度
     *
     * @param p
     * @param q
     */
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        // 根据两个元素所在树的元素个数不同判断合并方向
        // 将元素个数少的集合合并到元素个数多的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;

        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        UnionFindTestHelper.testUF3(n);
        UnionFindTestHelper.testUF4(n);
        UnionFindTestHelper.testUF5(n);
//        UnionFindTestHelper.testUF2(n);
//        UnionFindTestHelper.testUF1(n);
    }

}
