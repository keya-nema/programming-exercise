package com.example.exercise.datastructures.graph;

import java.util.*;

public class Graph<T> {

    private class Node<T> {
        private T value;
        private ArrayList<Node> edges = new ArrayList();

        public void addEdge(Node node) {
            edges.add(node);
        }

        public ArrayList<Node> getEdges() {
            return edges;
        }

        public T getValue() {
            return value;
        }
    }

    private HashMap<T, Node> nodes;

    public Graph() {
        this.nodes = new HashMap();
    }

    public void addVertex(T value) {
        Node node = new Node();
        node.value = value;
        nodes.put(value, node);
    }

    public void addEdge(T value1, T value2) {
        if (nodes.size() > 0) {
            if (nodes.containsKey(value1) && nodes.containsKey(value2)) {
                Node sourceNode = nodes.get(value1);
                sourceNode.addEdge(nodes.get(value2));
            } else {
                System.out.println("Source or Target nodes doesn't exist in the Graph");
            }
        }
    }

    public void printGraph() {
        for (T node : nodes.keySet()) {
            System.out.println(node);
        }
    }

    public void traverseNodes() {
        depthFirstTraversal(nodes.values());
    }

    private Set<Node> visitedNodes = new HashSet<>();

    private void depthFirstTraversal(Collection<Node> values) {
        if (values.isEmpty()) {
            return;
        }

        for (Node n : values) {
            if (visitedNodes.contains(n)) {
                System.out.println(n.getValue() + " is already visited.");
                continue;
            } else {
                System.out.println("Visiting: " + n.getValue());
                depthFirstTraversal(n.edges);
                markVisited(n);
            }
        }

    }

    private void markVisited(Node n) {
        System.out.println("Visit to Node " + n.getValue() + " completed.");
        visitedNodes.add(n);
    }

}
