package com.foothill;

import java.util.LinkedList;

public class Graph<E>{
    private Node<E>[] nodes;

    Graph(E[] values, int[][] edges) {
        nodes = (Node<E>[]) new Node[values.length];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node<>();

            Node<E> curr_node = nodes[i];

            curr_node.setValue(values[i]);
            //System.out.println("curr_node.getValue() = " + curr_node.getValue());
        }

        addEdgesToGraph(edges);

        for (Node<E> node : nodes) {
            System.out.println(node.getValue());
            System.out.println(node.getEdges());
        }

    }

    private void addEdgesToGraph(int[][] edges) {
        for (int row = 0; row < edges.length; row++)
        {
            int firstPoint = edges[row][0];
            int secondPoint = edges[row][1];

            nodes[firstPoint].addEdge(secondPoint);
            nodes[secondPoint].addEdge(firstPoint);
        }
    }

    public LinkedList<E> breadthFirstSearchOrder(int root) {
        return null;
    }

}
