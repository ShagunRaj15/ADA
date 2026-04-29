class Practical6 {
    static void run() {
        System.out.println("===== Practical 6: 0/1 Knapsack =====");
        int[] weights = {1, 3, 4, 5};
        int[] values  = {1, 4, 5, 7};
        int capacity  = 7;
        int n = weights.length;
 
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                dp[i][w] = dp[i - 1][w];
                if (weights[i - 1] <= w)
                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
            }
        }
 
        
        boolean[] selected = new boolean[n];
        int w = capacity;
        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                selected[i - 1] = true;
                w -= weights[i - 1];
            }
        }
 
        System.out.println("Max Profit: " + dp[n][capacity]);
        System.out.print("Selected Items (1-indexed): ");
        for (int i = 0; i < n; i++)
            if (selected[i]) System.out.print((i + 1) + " ");
        System.out.println("\n");
    }
}