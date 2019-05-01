import java.util.*;
public class ArticulationPoint {
    private int time;
    public  Set<vertex> findArticulationPoint(vertex startVertex){
        time=0;
        Set<vertex> visited=new HashSet<>();
        Set<vertex> articulationPoints=new HashSet<>();
        Map<vertex,Integer> visitedTime=new HashMap<>();
        Map<vertex,Integer> lowTime=new HashMap<>();
        Map<vertex,vertex> parent=new HashMap<>();
        DFS(visited,articulationPoints,startVertex,visitedTime,lowTime,parent);
        return articulationPoints;
    }
    private void DFS(Set<vertex> visited,Set<vertex> articulationPoints,vertex vertex,Map<vertex,Integer> visitedTime,Map<vertex,Integer> lowTime,Map<vertex,vertex> parent){
        visited.add(vertex);
        visitedTime.put(vertex,time);
        lowTime.put(vertex,time);
        time++;
        int childCount=0;
        boolean isArticulationPoint=false;
        for(vertex adj:vertex.getNeighbours()){
            if(adj.equals(parent.get(vertex))){
                continue;
            }
            if(!visited.contains(adj)){
                parent.put(adj,vertex);
                childCount++;
                DFS(visited,articulationPoints,adj,visitedTime,lowTime,parent);
                if(visitedTime.get(vertex)<=lowTime.get(adj)){
                    isArticulationPoint=true;
                }else{
                    lowTime.compute(vertex,(currentVertex,time)->
                            Math.min(time,lowTime.get(adj)));
                }
            }else{
                lowTime.compute(vertex,(currentVertex,time)->
                        Math.min(time,visitedTime.get(adj)));
            }
        }
        if(parent.get(vertex)==null && childCount>=2 || parent.get(vertex)!=null && isArticulationPoint){
            articulationPoints.add(vertex);
        }
    }
}
