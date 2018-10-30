package com.company.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class webCrowler {
    private Queue<String> queue;
    private List<String> disweb;
    public webCrowler(){
        this.queue=new LinkedList<>();
        this.disweb=new ArrayList<>();
    }
    public void discover(String root) {
        this.queue.add(root);
        this.disweb.add(root);
        while(!queue.isEmpty()){
            String v=queue.remove();
            String raw=readUrl(v);
            String regex="https://(\\w+\\.)*(\\w+)";
            Pattern pattern=Pattern.compile(regex);
            Matcher matcher=pattern.matcher(raw);
            while(matcher.find()){
                String actual=matcher.group();
                if(!disweb.contains(actual)){
                    disweb.add(actual);
                    System.out.println("Website found:"+actual);
                    queue.add(actual);
                }
            }
        }
    }
    public String readUrl(String v){
        String raw="";
        try {
            URL url = new URL(v);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String input="";
            while((input=br.readLine())!=null){
                raw+=input;
            }
            br.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return raw;
    }
}
