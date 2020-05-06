package com.example.exercise.datastructures.linkedlist;

public class SinglyLinkedList<T> {

    private class Node {
        T value;
        Node next;
    }

    private Node currentNode;
    private Node topNode;

    public void add(T value) {
        Node node = new Node();
        node.value = value;
        node.next = null;
        if (currentNode == null) {
            currentNode = node;
            topNode = node;
        } else {
            currentNode.next = node;
            currentNode = node;
        }
    }

    public void deleteNode(T value) {
        if (topNode != null) {
            Node previousNode = null;
            Node node = topNode;
            while (node != null) {
                if (node.value.equals(value)) {
                    // this is the node to be deleted
                    if (previousNode != null) {
                        previousNode.next = node.next;
                    } else {
                        topNode = node.next;
                    }
                    break;
                } else {
                    previousNode = node;
                    node = node.next;
                }
            }
        } else {
            System.out.println("List is empty.");
        }
    }

    public void printList() {
        if (topNode != null) {
            Node node = topNode;
            while (node != null) {
                System.out.print(node.value + " ");
                node = node.next;
            }
            System.out.println();
        }
    }

    public void reverseList() {
        if (topNode != null) {
            Node tempTopNode = topNode;
            Node tempCurrentNode = currentNode;

            Node node = topNode;
            Node previousNode = null;
            Node nextNode;
            while (node != null) {
                nextNode = node.next;
                node.next = previousNode;
                previousNode = node;
                node = nextNode;
            }

            topNode = tempCurrentNode;
            currentNode = tempTopNode;
        } else {
            System.out.println("List is empty. Can not reverse.");
        }
    }
}
