import java.util.*;

public class NegativeCycle {
    public static ArrayList<Integer>[] adj;
    public static ArrayList<Integer>[] cost;

    private static int negativeCycle() {
        int n = adj.length;

        // initialize starting distances to vertex index
        long[] dist = new long[n];
        for (int i = 0; i < n; i++)
            dist[i] = i;

        // loop n - 1 times for Bellman-Ford Algorithm
        // and nth time to determine negative cycle
        for (int i = 0; i < n; i++)
            // looping through each vertex
            for (int v = 0; v < n; v++)
                // looping through each edge connected to the vertex
                for (int j = 0; j < adj[v].size(); j++) {
                    int u = adj[v].get(j);
                    int c = cost[v].get(j);
                    // relax method if distance can be improved
                    if (dist[u] > dist[v] + c) {
                        dist[u] = dist[v] + c;
                        // check for negative cycle at nth time
                        if (i == n-1) return 1;
                    }
                }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        adj = new ArrayList[n];
        cost = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        System.out.println(negativeCycle());
    }
}
