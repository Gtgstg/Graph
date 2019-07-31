import java.util.*;
public class topological {
    private Stack<vertex> stack;
    public topological(){
        this.stack=new Stack<>();
    }
    public void dfs(vertex vertex){
        vertex.setVisited(true);
        for(vertex v:vertex.getNeighbour()){
            if(!v.isVisited()){
                dfs(v);
            }
        }
        stack.push(vertex);
    }
    public Stack<vertex> getStack(){
        return this.stack;
    }
}
