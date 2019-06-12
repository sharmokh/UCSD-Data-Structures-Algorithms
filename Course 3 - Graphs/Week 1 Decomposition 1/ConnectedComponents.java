import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    public static ArrayList<Integer>[] adj;

    // Determine number of Connected Components using DFS and marking vertices as visited
    private static int numberOfComponents() {
        boolean[] visited = new boolean[adj.length];
        int count = 0;
        for (int v = 0; v < visited.length; v++)
            if (!visited[v]) {
                DFS(v, visited);
                count++;
            }
        return count;
    }

    // Depth first search using visited to mark vertices
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
        System.out.println(numberOfComponents());
    }
}
