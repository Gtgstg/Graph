package com.company;

import java.util.ArrayList;
import java.util.List;

public class vertex<T> {
    private T name;
    private boolean visited;
    private boolean beingVisited;
    private List<vertex<T>> adjList;
    public vertex(T name){
        this.name=name;
        this.adjList=new ArrayList<>();
    }
    public void add(vertex<T> v){
        this.adjList.add(v);
    }
    public List<vertex<T>> getAdjList() {
        return adjList;
    }

    public void setAdjList(List<vertex<T>> adjList) {
        this.adjList = adjList;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }
}
