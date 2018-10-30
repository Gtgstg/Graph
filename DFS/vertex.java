package com.company.DFS;

import java.util.ArrayList;
import java.util.List;

public class vertex {
    private String name;
    private boolean visited;
    private List<vertex> neighbours;
    public vertex(String name){
        this.name=name;
        this.neighbours=new ArrayList<>();
    }
    public void addNeighbours(vertex vertex){
        this.neighbours.add(vertex);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
