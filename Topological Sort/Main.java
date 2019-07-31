import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        topological t=new topological();
        List<vertex> graph=new ArrayList<>();
        graph.add(new vertex("0"));
        graph.add(new vertex("1"));
        graph.add(new vertex("2"));
        graph.add(new vertex("3"));
        graph.add(new vertex("4"));
        graph.add(new vertex("5"));
        graph.get(2).addNeighbour(graph.get(3));
        graph.get(3).addNeighbour(graph.get(1));
        graph.get(4).addNeighbour(graph.get(0));
        graph.get(4).addNeighbour(graph.get(1));
        graph.get(5).addNeighbour(graph.get(0));
        graph.get(5).addNeighbour(graph.get(2));
        for(int i=0;i<graph.size();i++){
            if(!graph.get(i).isVisited()) t.dfs(graph.get(i));
        }
        Stack<vertex> stack=t.getStack();
        for(int i=0;i<graph.size();i++){
            vertex vertex=stack.pop();
            System.out.print(vertex+" -> ");
        }
    }
}
