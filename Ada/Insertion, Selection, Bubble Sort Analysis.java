class Practical2 {
    static int[] generateArray(int size, String type) {
        int[] arr = new int[size];
        if (type.equals("best")) {
            for (int i = 0; i < size; i++) arr[i] = i + 1; 
        } else if (type.equals("worst")) {
            for (int i = 0; i < size; i++) arr[i] = size - i; 
        } else {
            Random rand = new Random(42);
            for (int i = 0; i < size; i++) arr[i] = rand.nextInt(1000);
        }
        return arr;
    }

    static long bubbleSort(int[] arr) {
        arr = arr.clone();
        long comparisons = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = t;
                }
            }
        return comparisons;
    }

    static long selectionSort(int[] arr) {
        arr = arr.clone();
        long comparisons = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int t = arr[minIdx]; arr[minIdx] = arr[i]; arr[i] = t;
        }
        return comparisons;
    }

    static long insertionSort(int[] arr) {
        arr = arr.clone();
        long comparisons = 0;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i], j = i - 1;
            while (j >= 0 && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                j--;
            }
            comparisons++;
            arr[j + 1] = key;
        }
        return comparisons;
    }

    static void run() {
        System.out.println("===== Practical 2: Sorting Analysis =====");
        int[] sizes = {10, 20, 30, 40};
        String[] cases = {"best", "average", "worst"};

        for (String c : cases) {
            System.out.println("\n--- " + c.toUpperCase() + " CASE ---");
            System.out.printf("%-6s %-12s %-12s %-12s%n", "Size", "Bubble", "Selection", "Insertion");
            for (int size : sizes) {
                int[] arr = generateArray(size, c);
                System.out.printf("%-6d %-12d %-12d %-12d%n",
                    size, bubbleSort(arr), selectionSort(arr), insertionSort(arr));
            }
        }
        System.out.println("\nComplexity: Best O(n), Average O(n^2), Worst O(n^2)");
        System.out.println();
    }
}