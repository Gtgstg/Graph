package com.company.BFS;

public class Main {

    public static void main(String[] args) {
        BFS bfs=new BFS();
        vertex v1=new vertex(1);
        vertex v2=new vertex(2);
        vertex v3=new vertex(3);
        vertex v4=new vertex(4);
        vertex v5=new vertex(5);
        v1.addneighbour(v2);
        v1.addneighbour(v4);
        v2.addneighbour(v5);
        v4.addneighbour(v3);
        bfs.bfs(v1);
    }
}
