package com.example.exercise.run;

import com.example.exercise.datastructures.linkedlist.SinglyLinkedList;

public class ReverseLinkedList {

    public static void main(String[] args) {
        int[] input = new int[] {0,1,2,3,4,5};
        SinglyLinkedList list = createList(input);
        list.printList();
        list.deleteNode(0);
        list.printList();
        reverseList(list);
        list.printList();
    }

    private static void reverseList(SinglyLinkedList list) {
        list.reverseList();
    }

    private static SinglyLinkedList createList(int[] input) {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i : input) {
            list.add(i);
        }
        return list;
    }
}
