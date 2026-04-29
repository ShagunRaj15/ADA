class Practical5 {
    static void run() {
        System.out.println("===== Practical 5: Fractional Knapsack =====");
        int[] weights = {2, 3, 5, 7, 1, 4, 1};
        int[] values  = {10, 5, 15, 7, 6, 18, 3};
        int capacity  = 15;
        int n = weights.length;

        
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        Arrays.sort(indices, (a, b) ->
            Double.compare((double) values[b] / weights[b], (double) values[a] / weights[a]));

        double totalValue = 0;
        double[] fractions = new double[n];
        int remaining = capacity;

        for (int idx : indices) {
            if (remaining >= weights[idx]) {
                fractions[idx] = 1.0;
                totalValue += values[idx];
                remaining -= weights[idx];
            } else if (remaining > 0) {
                fractions[idx] = (double) remaining / weights[idx];
                totalValue += fractions[idx] * values[idx];
                remaining = 0;
            }
        }

        System.out.println("Items (Weight, Value, Ratio):");
        for (int i = 0; i < n; i++)
            System.out.printf("  Item %d: w=%d, v=%d, ratio=%.2f, fraction taken=%.2f%n",
                i + 1, weights[i], values[i], (double) values[i] / weights[i], fractions[i]);
        System.out.printf("Max Profit = %.2f%n%n", totalValue);
    }
}