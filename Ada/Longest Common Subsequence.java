class Practical7 {
    static void run() {
        System.out.println("===== Practical 7: Longest Common Subsequence =====");
        String s1 = "ABCBDAB", s2 = "BDCAB";
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
 
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
 
        
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.insert(0, s1.charAt(i - 1));
                i--; j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) i--;
            else j--;
        }
 
        System.out.println("String 1: " + s1);
        System.out.println("String 2: " + s2);
        System.out.println("LCS Length: " + dp[m][n]);
        System.out.println("LCS: " + lcs);
        System.out.println();
    }
}
 