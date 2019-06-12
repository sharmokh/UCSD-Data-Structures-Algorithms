import java.util.*;

public class Acyclicity {
    private static ArrayList<Integer>[] adj;

    private static int acyclic() {
        // track to determine if vertex is visited using boolean
        boolean[] visited = new boolean[adj.length];

        // check each vertex if it contains a cycle
        // if cycle return 1
        for (int v = 0; v < visited.length; v++)
            if (cyclicDFS(v, visited))
                return 1;

        // return 0 after checking all vertices
        return 0;
    }

    private static boolean cyclicDFS(int v, boolean[] visited) {

        // if vertex already visited than we have a cycle - return true
        if (visited[v]) return true;

        // mark as visited
        visited[v] = true;

        for (int u : adj[v])
            if (cyclicDFS(u, visited))
                return true;

        // mark as not visited to be able to check next vertex
        visited[v] = false;
        return false;
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
        }
        System.out.println(acyclic());
    }
}
