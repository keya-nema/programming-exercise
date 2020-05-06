package com.example.exercise.run;

import com.example.exercise.datastructures.BinaryTree;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode(1);
        binaryTree.addNode(2);
        binaryTree.addNode(3);
        binaryTree.addNode(4);
        binaryTree.addNode(5);
        binaryTree.addNode(6);
        binaryTree.addNode(7);
        binaryTree.addNode(8);
        binaryTree.addNode(9);
        binaryTree.printGraph();
    }
}
