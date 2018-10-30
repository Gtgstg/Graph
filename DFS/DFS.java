package com.company.DFS;

import java.util.List;
import java.util.Stack;

public class DFS {
    private Stack<vertex> stack;
    public DFS(){
        this.stack=new Stack<>();
    }
    public void dfs(List<vertex> vertexList){
        for(vertex v:vertexList){
         if(!v.isVisited()){
             v.setVisited(true);
             dfsWithStack(v);
             //dfsrecursion(v);
         }
        }
    }
    public void dfsrecursion(vertex v){
        System.out.println(v+" ");
        for(vertex vertex:v.getNeighbours() ){
            if(!vertex.isVisited()){
                vertex.setVisited(true);
                dfsrecursion(vertex);
            }
        }
    }
    public void dfsWithStack(vertex root){
        this.stack.add(root);
        root.setVisited(true);
        while(!stack.isEmpty()){
            vertex actual=this.stack.pop();
            System.out.println(actual+" ");
            for(vertex v:actual.getNeighbours()){
                if(!v.isVisited()){
                    v.setVisited(true);
                    this.stack.push(v);
                }
            }
        }
    }
}
