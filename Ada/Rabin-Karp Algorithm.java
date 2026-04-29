class Practical16 {
    static final int d = 256;
    static final int q = 101; // Prime
 
    static void run() {
        System.out.println("===== Practical 16: Rabin-Karp Algorithm =====");
        String text    = "GEEKS FOR GEEKS";
        String pattern = "GEEK";
        int m = pattern.length(), n = text.length();
        int h = 1, p = 0, t = 0;
        List<Integer> matches = new ArrayList<>();
 
        for (int i = 0; i < m - 1; i++) h = (h * d) % q;
        for (int i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }
 
        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                boolean match = true;
                for (int j = 0; j < m; j++)
                    if (text.charAt(i + j) != pattern.charAt(j)) { match = false; break; }
                if (match) matches.add(i);
            }
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (t < 0) t += q;
            }
        }
 
        System.out.println("Text:    " + text);
        System.out.println("Pattern: " + pattern);
        System.out.println("Pattern found at indices: " + matches);
        System.out.println("Complexity: Average O(n+m), Worst O(nm)");
        System.out.println();
    }
}