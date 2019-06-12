import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {
    private static ArrayList<Integer>[] adj;

    // Determine if all vertices are reachable (or connected)
    // 0 if not connected & 1 if connected
    private static int reach(int x) {
        boolean[] visited = new boolean[adj.length];
        DFS(x, visited);
        for (boolean v : visited) {
            if (!v) return 0;
        }
        return 1;
    }

    // Depth first search and mark each vertex as visited
    private static void DFS(int v, boolean[] visited) {
        visited[v] = true;
        for (int u : adj[v])
            if (!visited[u])
                DFS(u, visited);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        adj = (ArrayList<Integer>[])new ArrayList[n];
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
        System.out.println(reach(x));
    }
}
