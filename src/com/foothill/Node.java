package com.foothill;

import java.util.ArrayList;

// This class contains a list of nodes and their connections with each other
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

    public String toString() {
        return value.toString();
    }

    // adds a point that is connected to the current node indicating an edge
    public void addEdge(int e) {
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
        if (edges == null) {
            return true;
        }

        return false;
    }

}
