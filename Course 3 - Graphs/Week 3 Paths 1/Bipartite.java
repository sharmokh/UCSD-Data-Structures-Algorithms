import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
    public static ArrayList<Integer>[] adj;

    private static int bipartite() {
        int[] dist = new int[adj.length];
        for (int i = 0; i < dist.length; i++)
            dist[i] = -1;

        // process distances from vertices in case of disconnected graph
        for (int i = 0; i < dist.length; i++)
            if (dist[i] == -1) {
                int result = bipartiteBFS(i, dist);
                // if any connected graph is not bipartite, break and return 0
                if (result == 0)
                    return 0;
            }
        // return 1 if bipartite
        return 1;
    }

    private static int bipartiteBFS(int s, int[] dist) {

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
                    // if u and v are on same level and connected,
                    // there distances will be the same - not bipartite
                    else if (dist[u] == dist[v]) {
                        return 0;
                    }
                }
            }
        }
        // return 1 if bipartite
        return 1;
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
        System.out.println(bipartite());
    }
}
