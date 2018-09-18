package com.cloudy.graph;

/**
 * created by lijianyun on 2018/9/17
 */
public interface Graph {
    int v();

    int edge();

    void addEdge(int v, int w);

    boolean hasEdge(int v, int w);

    void show();

    Iterable<Integer> adj(int v);
}
