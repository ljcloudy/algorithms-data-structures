package com.cloudy.graph;

/**
 * created by lijianyun on 2018/9/17
 */
public class Main {
    public static void main(String[] args) {
        String filename = "testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph rg1 = new ReadGraph(g1, filename);
        System.out.println("test G1 Sparse Graph:");
        g1.show();


        System.out.println();

        DenseGraph g2 = new DenseGraph(13, false);
        ReadGraph rg2 = new ReadGraph(g2, filename);
        System.out.println("test G1 in Dense Graph:");
        g2.show();
    }
}