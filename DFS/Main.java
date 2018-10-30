package com.company.DFS;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<vertex> list=new ArrayList<>();
	    vertex v1=new vertex("1");
        vertex v2=new vertex("2");
        vertex v3=new vertex("3");
        vertex v4=new vertex("4");
        vertex v5=new vertex("5");
        v1.addNeighbours(v2);
        v2.addNeighbours(v3);
        v3.addNeighbours(v4);
        v4.addNeighbours(v5);
        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);
        list.add(v5);
        DFS dfs=new DFS();
        dfs.dfs(list);
    }
}
