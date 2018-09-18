package com.cloudy.graph;

import java.util.Vector;

/**
 * 稠密图 - 邻接矩阵
 * created by lijianyun on 2018/9/17
 */
public class DenseGraph implements Graph {

    private int n;//节点数

    private int m;//边数

    private boolean directed; //是否为有向图

    private boolean[][] g; //图的具体数据

    public DenseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        //g初始化为n*n的布尔矩阵，每一个g[i][j]均为false，表示没有任何边
        g = new boolean[n][n];
    }

    /**
     * 返回边的个数
     *
     * @return
     */
    public int edge() {
        return m;
    }

    public int v() {
        return n;
    }

    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        if (hasEdge(v, w)) {
            return;
        }
        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
        }
        m++;
    }

    /**
     * 验证图中是否有从v到w的边
     *
     * @param v
     * @param w
     * @return
     */
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        return g[v][w];
    }

    /**
     * 返回图中一个顶点的所有邻边
     *
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Integer> adjV = new Vector<>();
        for (int i = 0; i < n; i++) {
            if (g[v][i]) {
                adjV.add(i);
            }
        }
        return adjV;
    }

    @Override
    public void show() {
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ )
                System.out.print(g[i][j]+"\t");
            System.out.println();
        }

    }
}
