import java.util.ArrayList;
import java.util.List;

public class vertex {
    private String data;
    private boolean visited;
    private List<vertex> neighbour;
    public vertex(String data){
        neighbour=new ArrayList<>();
        this.data=data;
    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return this.data;
    }

    public List<vertex> getNeighbour() {
        return neighbour;
    }

    public void setNeighbour(List<vertex> neighbour) {
        this.neighbour = neighbour;
    }
    public void addNeighbour(vertex vertex){
        this.neighbour.add(vertex);
    }
}
