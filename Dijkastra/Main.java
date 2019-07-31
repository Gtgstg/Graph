package com.company;

public class Main {

    public static void main(String[] args) {
	    Vertex v1=new Vertex("A");
	    Vertex v2=new Vertex("B");
	    Vertex v3=new Vertex("C");
	    v1.addNeighbours(new Edge(1,v1,v2));
	    v1.addNeighbours(new Edge(3,v1,v3));
	    v2.addNeighbours(new Edge(1,v2,v3));
	    Dijkastra d=new Dijkastra();
	    d.computePaths(v1);
	    System.out.println(d.getShortestPath(v2));
        System.out.println(d.getShortestPath(v3));
    }
}
