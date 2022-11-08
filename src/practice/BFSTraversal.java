package practice;

import java.util.*;

public class BFSTraversal {
    private Vertex startVertex;
    public BFSTraversal(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public void traverse() {
        Vertex root = startVertex;
        Queue<Vertex> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Vertex curVal = q.poll();
            if(!curVal.isVisited()) {
                curVal.setVisited(true);
                System.out.println("curVal = " + curVal);
                q.addAll(curVal.getNeighbours());
            }

        }

    }

    public static void main(String[] args) {
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        v0.setNeighbours(Arrays.asList(v1,v3,v4));
        BFSTraversal traversal = new BFSTraversal(v0);
        traversal.traverse();
    }
}


class Vertex {
    private  int data;
    private boolean visited;
    private List<Vertex> neighbours = new LinkedList<>();

    public Vertex(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Vertex> neighbours) {
        this.neighbours = neighbours;
    }
}
