package com.foothill;

import java.util.ArrayList;

public class Node<E> {
    private E value;
    private boolean visited = false;
    ArrayList<Integer> edges;

    public void setValue(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void addEdge(int e)
    {
        if (edgesIsEmpty())
            edges = new ArrayList<>();

        if (edges.contains(e))
            return;

        edges.add(e);
    }

    public ArrayList<Integer> getEdges() {
        return edges;
    }

    public boolean edgesIsEmpty() {
        if (edges == null){
            return true;
        }

        return false;
    }

}
