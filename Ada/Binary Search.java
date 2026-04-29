class Practical3 {
    static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    static void run() {
        System.out.println("===== Practical 3: Binary Search =====");
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72};
        System.out.println("Array: " + Arrays.toString(arr));

        System.out.println("Search 23 (average): index = " + binarySearch(arr, 23));
        System.out.println("Search 2 (best - mid): index = " + binarySearch(arr, 2));
        System.out.println("Search 99 (worst - not found): index = " + binarySearch(arr, 99));

        System.out.println("\nComplexity:");
        System.out.println("Best: O(1), Average: O(log n), Worst: O(log n)");

        System.out.println("\nGraph Data (n vs comparisons approx):");
        System.out.printf("%-10s %-15s%n", "n", "log2(n)");
        for (int n : new int[]{10, 20, 30, 40, 50, 100}) {
            System.out.printf("%-10d %-15.2f%n", n, Math.log(n) / Math.log(2));
        }
        System.out.println();
    }
}