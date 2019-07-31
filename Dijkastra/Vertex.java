package com.company;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    private String name;
    private List<Edge> adjanciesList;
    private boolean visited;
    private Vertex predecessor;
    private double distance=Double.MAX_VALUE;
    public Vertex(String name){
        this.name=name;
        this.adjanciesList=new ArrayList<>();
    }
    public void addNeighbours(Edge edge){
        this.adjanciesList.add(edge);
    }
    @Override
    public String toString() {
        return this.name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Edge> getAdjanciesList() {
        return adjanciesList;
    }
    public void setAdjanciesList(List<Edge> adjanciesList) {
        this.adjanciesList = adjanciesList;
    }
    public boolean isVisited() {
        return visited;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    public Vertex getPredecessor() {
        return predecessor;
    }
    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.distance,otherVertex.getDistance());
    }
}
