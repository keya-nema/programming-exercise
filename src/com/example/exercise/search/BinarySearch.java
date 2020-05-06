package com.example.exercise.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] input = new int[] { 1, 2, 3, 4, 5, 6 };
        int searchElement = 2;

        if (input == null || input.length == 0) {
            return;
        } else if (input.length == 1) {
            if (input[0] == searchElement) {
                return;
            }
        } else {
            int element = binarySearch(0, input.length - 1, input, searchElement);
            if (element == -1) {
                System.out.println("Element " + searchElement + " not found.");
            } else {
                System.out.println("Element " + searchElement + " found at index: " + element);
            }
        }
    }

    private static int binarySearch(int left, int right, int input[], int searchElement) {
        if (left == right) {
            if (input[left] == searchElement) {
                return left;
            } else {
                return -1;
            }
        }
        int mid = (right + left) / 2;
        int midElement = input[mid];
        if (searchElement == midElement) {
            return mid;
        } else if (searchElement < midElement) {
            return binarySearch(left, mid, input, searchElement);
        } else if (searchElement > midElement) {
            return binarySearch(mid + 1, right, input, searchElement);
        } else {
            return -1;
        }
    }
}
