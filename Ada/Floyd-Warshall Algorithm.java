class Practical15 {
    static final int INF = 99999;
 
    static void run() {
        System.out.println("===== Practical 15: Floyd-Warshall Algorithm =====");
        int n = 4;
        int[][] dist = {
            {0,   5,  INF, 10},
            {INF, 0,   3,  INF},
            {INF, INF, 0,   1},
            {INF, INF, INF, 0}
        };
 
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][k] != INF && dist[k][j] != INF)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
 
        System.out.println("All-pairs shortest paths:");
        System.out.printf("%-6s", "");
        for (int i = 0; i < n; i++) System.out.printf("%-6d", i);
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf("%-6d", i);
            for (int j = 0; j < n; j++)
                System.out.printf("%-6s", dist[i][j] == INF ? "INF" : dist[i][j]);
            System.out.println();
        }
        System.out.println("Complexity: O(n^3)");
        System.out.println();
    }
}