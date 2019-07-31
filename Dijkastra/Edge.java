package com.company;

public class Edge {
    private double weight;
    private Vertex startVertex;
    private Vertex targerVertex;
    public Edge(double weight,Vertex startVertex,Vertex targerVertex){
        this.weight=weight;
        this.startVertex=startVertex;
        this.targerVertex=targerVertex;
    }
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getTargerVertex() {
        return targerVertex;
    }

    public void setTargerVertex(Vertex targerVertex) {
        this.targerVertex = targerVertex;
    }
}
