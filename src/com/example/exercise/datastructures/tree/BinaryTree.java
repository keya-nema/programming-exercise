package com.example.exercise.datastructures.tree;

import java.util.ArrayList;

public class BinaryTree<T> {

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
            ArrayList<Node> list = new ArrayList<>();
            list.add(rootNode);
            iterateGraphAndAddNode(node, list);
        }
    }

    private boolean iterateGraphAndAddNode(Node node, ArrayList<Node> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Node iterNode = list.get(0);
        if (iterNode.left == null) {
            System.out.println("Adding new left node " + node.value + " to " + iterNode.value);
            iterNode.left = node;
            return true;
        } else if (iterNode.right == null) {
            System.out.println("Adding new right node " + node.value + " to " + iterNode.value);
            iterNode.right = node;
            return true;
        } else {
            // add the left and right node in the order to be traversed
            list.remove(iterNode);
            list.add(iterNode.left);
            list.add(iterNode.right);
            iterateGraphAndAddNode(node, list);
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
