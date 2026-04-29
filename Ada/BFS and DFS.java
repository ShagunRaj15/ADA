class Practical11 {
    static int V = 6;
    static List<List<Integer>> adj = new ArrayList<>();
 
    static void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        System.out.print("BFS: ");
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for (int u : adj.get(v))
                if (!visited[u]) { visited[u] = true; queue.add(u); }
        }
        System.out.println();
    }
 
    static boolean[] dfsVisited;
    static void dfsHelper(int v) {
        dfsVisited[v] = true;
        System.out.print(v + " ");
        for (int u : adj.get(v))
            if (!dfsVisited[u]) dfsHelper(u);
    }
 
    static void run() {
        System.out.println("===== Practical 11: BFS and DFS =====");
        adj.clear();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        int[][] edges = {{0,1},{0,2},{1,3},{2,4},{3,5},{4,5}};
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
 
        bfs(0);
        dfsVisited = new boolean[V];
        System.out.print("DFS: ");
        dfsHelper(0);
        System.out.println();
 
        System.out.println("Time Complexity: O(V + E)");
        System.out.println();
    }
}