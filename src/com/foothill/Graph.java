package com.foothill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

// this class creates a graph out of a set of nodes and edges
public class Graph<E> {
    private Node<E>[] nodes;

    Graph(E[] values, int[][] edges) {
        nodes = (Node<E>[]) new Node[values.length];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node<>();
            Node<E> curr_node = nodes[i];
            curr_node.setValue(values[i]);
        }
        addEdgesToGraph(edges);
    }

    // takes in a 2D array where each new row indicates one new edge
    private void addEdgesToGraph(int[][] edges) {
        for (int row = 0; row < edges.length; row++) {
            int firstPoint = edges[row][0];
            int secondPoint = edges[row][1];
            nodes[firstPoint].addEdge(secondPoint);
            nodes[secondPoint].addEdge(firstPoint);
        }
    }

    public String toString() {
        return "Graph{" +
                "nodes=" + Arrays.toString(nodes) +
                '}';
    }

    // takes the starting root node index and traverses all of a given graph in breadth first search order returning the order of the path taken
    public LinkedList<E> breadthFirstSearchOrder(int root) {
        LinkedList<Node<E>> queue = new LinkedList<>();
        LinkedList<E> orderOfVisitedNodes = new LinkedList<>();
        queue.add(nodes[root]);
        nodes[root].setVisited(true);

        while (!queue.isEmpty()) {
            Node<E> removed = queue.remove();
            removed.setVisited(true);
            orderOfVisitedNodes.add((E) removed);
            for (int edge :
                    removed.getEdges()) {
                if (!nodes[edge].isVisited()) {
                    queue.add(nodes[edge]);
                    nodes[edge].setVisited(true);
                }
            }
        }
        // clearing all visited flags
        queue.add(nodes[root]);
        nodes[root].setVisited(false);
        while (!queue.isEmpty()) {
            Node<E> removed = queue.remove();
            removed.setVisited(false);
            for (int edge :
                    removed.getEdges()) {
                if (nodes[edge].isVisited()) {
                    queue.add(nodes[edge]);
                    nodes[edge].setVisited(false);
                }
            }
        }
        return orderOfVisitedNodes;
    }

}
