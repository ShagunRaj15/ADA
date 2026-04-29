class Practical17 {
    static void run() {
        System.out.println("===== Practical 17: Activity Selection Problem =====");
        int[] start  = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};
        int n = start.length;
 
        // Sort activities by finish time
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> finish[a] - finish[b]);
 
        List<Integer> selected = new ArrayList<>();
        int lastFinish = -1;
        for (int i : idx) {
            if (start[i] >= lastFinish) {
                selected.add(i + 1); // 1-indexed activity number
                lastFinish = finish[i];
            }
        }
 
        System.out.println("Activities (start, finish):");
        for (int i = 0; i < n; i++)
            System.out.printf("  A%d: (%d, %d)%n", i + 1, start[i], finish[i]);
        System.out.println("Selected Activities: " + selected);
        System.out.println("Maximum activities selected: " + selected.size());
        System.out.println("Complexity: O(n log n) for sorting + O(n) selection");
        System.out.println();
    }
}
 