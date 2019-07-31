package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    vertex v1=new vertex(1);
        vertex v2=new vertex(2);
        vertex v3=new vertex(3);
        vertex v4=new vertex(4);
        vertex v5=new vertex(5);
        vertex v6=new vertex(6);
        v1.add(v2);
        v1.add(v3);
        v2.add(v3);
        v4.add(v1);
        v4.add(v5);
        v5.add(v6);
        v6.add(v4);
        List<vertex> list=new ArrayList<>();
        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);
        list.add(v5);
        list.add(v6);
        CycleDetection c=new CycleDetection();
        c.detectCycle(list);
    }
}
