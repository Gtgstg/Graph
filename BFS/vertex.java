package com.company.BFS;

import java.util.ArrayList;
import java.util.List;

public class vertex {
    private int data;
    private boolean visited;
    private List<vertex> neighbours;
    public vertex(int data){
        this.data=data;
        this.neighbours=new ArrayList<>();
    }
    public void addneighbour(vertex vertex){
        this.neighbours.add(vertex);
    }

    @Override
    public String toString() {
        return ""+this.data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<vertex> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<vertex> neighbours) {
        this.neighbours = neighbours;
    }
}
