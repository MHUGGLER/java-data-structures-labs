import java.util.*;
public class DataStructures {

    // ==========================================
    // 1. RECURSION
    // ==========================================
    public static int recursiveSum(int n) {
        if (n == 0) return 0;         // Base case
        return n + recursiveSum(n - 1); // Recursive step
    }

    // ==========================================
    // 2. ANALYSIS OF ALGORITHMS
    // ==========================================
    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int max = arr[0];  
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // ==========================================
    // 3. TREES
    // ==========================================
    static class Node {
        int value;
        Node left, right;
        public Node(int value) {
            this.value = value;
        }
    }

    public static int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // ==========================================
    // 4. SEARCH ALGORITHMS
    // ==========================================
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // ==========================================
    // 5. SORTING ALGORITHMS
    // ==========================================
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {           
            for (int j = 0; j < n - 1 - i; j++) {  
                if (arr[j] > arr[j + 1]) {         
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // ==========================================
    // TEST DRIVER (Do not modify)
    // ==========================================
    public static void main(String[] args) {
        System.out.println("=== Coding Main Data Structures ===\n");

        int n = 5;
        int expectedSum = 15;
        int actualSum = recursiveSum(n);
        printTestResult("1. Recursion (Sum)", expectedSum, actualSum);

        int[] numbers = {10, 5, 20, 8, 15};
        int expectedMax = 20;
        int actualMax = findMax(numbers);
        printTestResult("2. Analysis (Find Max)", expectedMax, actualMax);

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        int expectedCount = 4;
        int actualCount = countNodes(root);
        printTestResult("3. Trees (Node Count)", expectedCount, actualCount);

        int[] searchData = {4, 2, 7, 1, 9};
        int target = 7;
        int expectedIndex = 2;
        int actualIndex = linearSearch(searchData, target);
        printTestResult("4. Search (Linear)", expectedIndex, actualIndex);

        int[] sortData = {64, 34, 25, 12, 22, 11, 90};
        String expectedSort = "[11, 12, 22, 25, 34, 64, 90]";
        bubbleSort(sortData);
        String actualSort = Arrays.toString(sortData);
        System.out.println("[Test 5] Sorting (Bubble Sort)");
        System.out.println(" Expected: " + expectedSort);
        System.out.println(" Actual: " + actualSort);
        if (expectedSort.equals(actualSort)) {
            System.out.println(" Result: [PASS]");
        } else {
            System.out.println(" Result: [FAIL]");
        }
        System.out.println();
    }

    private static void printTestResult(String testName, int expected, int actual) {
        System.out.println("[Test] " + testName);
        System.out.println(" Expected: " + expected);
        System.out.println(" Actual: " + actual);
        if (expected == actual) {
            System.out.println(" Result: [PASS]");
        } else {
            System.out.println(" Result: [FAIL]");
        }
        System.out.println();
    }
}