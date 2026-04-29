class Practical13 {
    static int[] set;
    static int targetSum;
    static List<List<Integer>> results = new ArrayList<>();
 
    static void subsetSum(int index, int current, List<Integer> path) {
        if (current == targetSum) {
            results.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < set.length; i++) {
            if (current + set[i] <= targetSum) {
                path.add(set[i]);
                subsetSum(i + 1, current + set[i], path);
                path.remove(path.size() - 1);
            }
        }
    }
 
    static void run() {
        System.out.println("===== Practical 13: Sum of Subsets =====");
        set = new int[]{3, 1, 4, 2, 2};
        targetSum = 6;
        Arrays.sort(set);
        results.clear();
        subsetSum(0, 0, new ArrayList<>());
        System.out.println("Set: " + Arrays.toString(set) + ", Target: " + targetSum);
        System.out.println("Subsets with sum " + targetSum + ":");
        for (List<Integer> s : results) System.out.println("  " + s);
        System.out.println();
    }
}