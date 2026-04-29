class Practical14 {
    static void run() {
        System.out.println("===== Practical 14: Naive String Matching =====");
        String text    = "AABAACAADAABAABA";
        String pattern = "AABA";
        int n = text.length(), m = pattern.length();
        int comparisons = 0;
        List<Integer> matches = new ArrayList<>();
 
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m) {
                comparisons++;
                if (text.charAt(i + j) != pattern.charAt(j)) break;
                j++;
            }
            if (j == m) matches.add(i);
        }
 
        System.out.println("Text:    " + text);
        System.out.println("Pattern: " + pattern);
        System.out.println("Pattern found at indices: " + matches);
        System.out.println("Total comparisons: " + comparisons);
        System.out.println("Complexity: O((n-m+1)*m)");
        System.out.println();
    }
}