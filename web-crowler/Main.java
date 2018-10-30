package com.company.BFS;

public class Main {

    public static void main(String[] args) {
        webCrowler wc=new webCrowler();
        String root="https://www.google.com";
        wc.discover(root);
    }
}
