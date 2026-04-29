class Practical4 {
    static long mergeComparisons = 0;
    static long quickComparisons = 0;

    static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] L = Arrays.copyOfRange(arr, l, m + 1);
        int[] R = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            mergeComparisons++;
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            quickComparisons++;
            if (arr[j] <= pivot) {
                i++;
                int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            }
        }
        int t = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = t;
        return i + 1;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static void run() {
        System.out.println("===== Practical 4: Merge Sort & Quick Sort =====");
        int[] sizes = {10, 20, 30, 40};

        System.out.println("\nMerge Sort Comparisons:");
        System.out.printf("%-10s %-12s %-12s %-12s%n", "Size", "Best", "Average", "Worst");
        for (int size : sizes) {
            long[] counts = new long[3];
            String[] cases = {"best", "average", "worst"};
            for (int c = 0; c < 3; c++) {
                int[] arr = Practical2.generateArray(size, cases[c]);
                mergeComparisons = 0;
                mergeSort(arr, 0, arr.length - 1);
                counts[c] = mergeComparisons;
            }
            System.out.printf("%-10d %-12d %-12d %-12d%n", size, counts[0], counts[1], counts[2]);
        }

        System.out.println("\nQuick Sort Comparisons:");
        System.out.printf("%-10s %-12s %-12s %-12s%n", "Size", "Best", "Average", "Worst");
        for (int size : sizes) {
            long[] counts = new long[3];
            String[] cases = {"best", "average", "worst"};
            for (int c = 0; c < 3; c++) {
                int[] arr = Practical2.generateArray(size, cases[c]);
                quickComparisons = 0;
                quickSort(arr, 0, arr.length - 1);
                counts[c] = quickComparisons;
            }
            System.out.printf("%-10d %-12d %-12d %-12d%n", size, counts[0], counts[1], counts[2]);
        }

        System.out.println("\nComplexity: Merge Sort O(n log n) all cases");
        System.out.println("Quick Sort Best/Average O(n log n), Worst O(n^2)");
        System.out.println();
    }
}