class Practical10 {
    static void run() {
        System.out.println("===== Practical 10: Bellman-Ford Algorithm =====");
        int n = 5;
       
        int[][] edges = {{0,1,6},{0,2,7},{1,2,8},{1,3,-4},{1,4,5},
                         {2,3,9},{2,4,-3},{3,0,2},{4,3,7}};
        int src = 0;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
 
        
        for (int i = 0; i < n - 1; i++) {
            for (int[] e : edges) {
                if (dist[e[0]] != Integer.MAX_VALUE && dist[e[0]] + e[2] < dist[e[1]])
                    dist[e[1]] = dist[e[0]] + e[2];
            }
        }
 
        
        boolean negativeCycle = false;
        for (int[] e : edges) {
            if (dist[e[0]] != Integer.MAX_VALUE && dist[e[0]] + e[2] < dist[e[1]]) {
                negativeCycle = true;
                break;
            }
        }
 
        if (negativeCycle) {
            System.out.println("Negative cycle detected!");
        } else {
            System.out.println("Shortest distances from vertex " + src + ":");
            for (int i = 0; i < n; i++)
                System.out.println("  To " + i + ": " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
        System.out.println();
    }
}