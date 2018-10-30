package com.company.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public void bfs(vertex root) {
        Queue<vertex> queue = new LinkedList<>();
        root.setVisited(true);
        queue.add(root);
        while(!queue.isEmpty()){
           vertex actual=queue.remove();
           System.out.println(actual.toString());
           for(vertex v:actual.getNeighbours()){
               if(!v.isVisited()){
                   v.setVisited(true);
                   queue.add(v);
               }
           }
        }
    }
}
