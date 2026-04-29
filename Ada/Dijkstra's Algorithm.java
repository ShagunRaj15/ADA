class Practical9 {
    static final int INF = Integer.MAX_VALUE;
 
    static void run() {
        System.out.println("===== Practical 9: Dijkstra's Algorithm =====");
        int n = 5;
        int[][] graph = {
            {0, 10, 0,  0, 5},
            {0,  0, 1,  0, 2},
            {0,  0, 0,  4, 0},
            {7,  0, 6,  0, 0},
            {0,  3, 9,  2, 0}
        };
        int src = 0;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
 
        for (int count = 0; count < n - 1; count++) {
            // Pick minimum distance vertex
            int u = -1;
            for (int v = 0; v < n; v++)
                if (!visited[v] && (u == -1 || dist[v] < dist[u])) u = v;
            visited[u] = true;
 
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INF
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
 
        System.out.println("Shortest distances from vertex " + src + ":");
        for (int i = 0; i < n; i++)
            System.out.println("  To " + i + ": " + (dist[i] == INF ? "INF" : dist[i]));
        System.out.println();
    }
}