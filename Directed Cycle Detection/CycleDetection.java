package com.company;

import java.util.List;

public class CycleDetection {
    public void detectCycle(List<vertex> vertexList){
        for(vertex vertex:vertexList){
            if(!vertex.isVisited())
                dfs(vertex);
        }
    }

    private void dfs(vertex vertex) {
        vertex.setBeingVisited(true);
        for(Object o:vertex.getAdjList()){
            vertex v=(vertex) o;
            if(v.isBeingVisited()){
                System.out.println("Cycle detected");
                return ;
            }
            if(!v.isVisited()){
                dfs(v);
            }
            vertex.setBeingVisited(false);
            vertex.setVisited(true);
        }
    }
}
