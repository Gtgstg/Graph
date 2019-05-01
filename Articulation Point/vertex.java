import java.util.*;

public class vertex {
    private int data;
    private List<vertex> Neighbours;
    public vertex(int data){
        this.data=data;
        this.Neighbours=new ArrayList<>();
    }
    public void addNeighbour(vertex vertex){
        this.Neighbours.add(vertex);
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public List<vertex> getNeighbours() {
        return Neighbours;
    }

    public void setNeighbours(List<vertex> neighbours) {
        Neighbours = neighbours;
    }
}
