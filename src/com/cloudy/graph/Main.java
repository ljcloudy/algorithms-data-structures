package com.cloudy.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * created by lijianyun on 2018/9/17
 */
public class Main {
    public static void main(String[] args) {
        String filename = "testG1.txt";
        SparseGraph g1 = new SparseGraph(14, false);
        ReadGraph rg1 = new ReadGraph(g1, filename);
        System.out.println("test G1 Sparse Graph:");
        g1.show();

        Components c1 = new Components(g1);
        int count = c1.count();
        System.out.println("count : " + count);

        Path path = new Path(g1,0);
        path.showPath(5);
        ShortestPath shortestPath = new ShortestPath(g1,0);
        shortestPath.showPath(6);


        System.out.println();

        DenseGraph g2 = new DenseGraph(13, false);
        ReadGraph rg2 = new ReadGraph(g2, filename);
        System.out.println("test G1 in Dense Graph:");
        g2.show();

    }
}
