package com.example.exercise.datastructures;

public class Graph<T> {

    private class Node {
        T value;
        Node left;
        Node right;
    }

    private Node rootNode;


    public void addNode(T value) {
        Node node = new Node();
        node.value = value;
        node.left = null;
        node.right = null;

        if (rootNode == null) {
            rootNode = node;
            System.out.println("Adding root node " + rootNode.value);
        } else {
            iterateGraphAndAddNode(node, rootNode);
        }
    }

    private boolean iterateGraphAndAddNode(Node node, Node rootNode) {
        if (rootNode == null) {
            return false;
        }
        Node iterNode = rootNode;
        if (iterNode.left == null) {
            System.out.println("Adding new left node " + node.value + " to " + iterNode.value);
            iterNode.left = node;
            return true;
        } else if (iterNode.right == null) {
            System.out.println("Adding new right node " + node.value + " to " + iterNode.value);
            iterNode.right = node;
            return true;
        } else {
            if (!iterateGraphAndAddNode(node, iterNode.left)) {
                iterateGraphAndAddNode(node, iterNode.right);
            }
        }
        return false;
    }

    public void printGraph() {
        Node node = rootNode;
        iterateGraphAndPrint(node);
    }

    private void iterateGraphAndPrint(Node rootNode) {
        if (rootNode == null) return;
        System.out.println(rootNode.value);
        iterateGraphAndPrint(rootNode.left);
        iterateGraphAndPrint(rootNode.right);
    }
}
