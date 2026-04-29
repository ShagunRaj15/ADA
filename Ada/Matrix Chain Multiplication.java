class Practical8 {
    static int[][] dp;
    static int[][] split;
 
    static String printOrder(int i, int j) {
        if (i == j) return "A" + i;
        return "(" + printOrder(i, split[i][j]) + " x " + printOrder(split[i][j] + 1, j) + ")";
    }
 
    static void run() {
        System.out.println("===== Practical 8: Matrix Chain Multiplication =====");
        int[] dims = {1, 2, 3, 4}; // Matrices: A1(1x2), A2(2x3), A3(3x4)
        int n = dims.length - 1;
        dp = new int[n + 1][n + 1];
        split = new int[n + 1][n + 1];
 
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dims[i - 1] * dims[k] * dims[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        split[i][j] = k;
                    }
                }
            }
        }
 
        System.out.println("Dimensions: " + Arrays.toString(dims));
        System.out.println("Minimum Scalar Multiplications: " + dp[1][n]);
        System.out.println("Optimal Parenthesization: " + printOrder(1, n));
        System.out.println();
    }
}