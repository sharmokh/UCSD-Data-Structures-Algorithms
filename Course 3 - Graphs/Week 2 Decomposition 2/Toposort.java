import java.util.*;

public class Toposort {
    private static ArrayList<Integer>[] adj;

    private static ArrayList<Integer> toposort() {

        // array used to keep track of visited vertices
        boolean[] visited = new boolean[adj.length];
        // list used to track the order vertices based on direction
        ArrayList<Integer> order = new ArrayList<Integer>();

        // depth first search while tracking visited vertices
        for (int v = 0; v < visited.length; v++)
            if (!visited[v])
                DFS(v, visited, order);

        // reverse and return the order
        Collections.reverse(order);
        return order;
    }

    private static void DFS(int v, boolean[] visited, ArrayList<Integer> order) {
        // set visited vertex to true
        visited[v] = true;
        // search for next vertex
        for (int u : adj[v])
            if (!visited[u])
                DFS(u, visited, order);
        // add vertex after adding deepest vertices (sink)
        order.add(v);
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
        ArrayList<Integer> order = toposort();
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}
