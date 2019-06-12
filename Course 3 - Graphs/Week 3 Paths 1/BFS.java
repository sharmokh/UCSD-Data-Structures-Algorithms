import java.util.*;

public class BFS {
    public static ArrayList<Integer>[] adj;

    private static int distance(int s, int t) {

        // declare and initialize distance levels to -1 (inifitity)
        int[] dist = new int[adj.length];
        for (int i = 0; i < dist.length; i++)
            dist[i] = -1;

        // process distances from s for each vertex
        bfs(s, dist);
        // return distance from s to t
        return dist[t];
    }

    private static void bfs(int s, int[] dist) {

        // initualize queue and process starting point
        Queue<Integer> process = new LinkedList<>();
        process.add(s);
        dist[s] = 0;

        // loop to process levels
        while (!process.isEmpty()) {
            // size of each level
            int n = process.size();
            for (int i = 0; i < n; i++) {
                // for each node in level
                int v = process.remove();
                for (int u : adj[v]) {
                    // if node is not processed
                    if (dist[u] == -1) {
                        dist[u] = dist[v] + 1;
                        process.add(u);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(x, y));
    }
}
