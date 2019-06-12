import java.util.*;

public class StronglyConnected {
    private static ArrayList<Integer>[] adj;

    private static int numberOfStronglyConnectedComponents() {

        // function to obtain the reverse directional graph
        ArrayList<Integer>[] revGraph = reverseGraph();

        // track the topological order of the reverse graph using DFS
        boolean[] visited = new boolean[adj.length];
        Stack<Integer> order = new Stack<>();
        for (int v = 0; v < visited.length; v++)
            if (!visited[v])
                reverseDFS(v, visited, order, revGraph);

        // count the number of times DFS is called on original graph
        // given the reverse graph DFS order
        int count = 0;
        while (!order.isEmpty()) {
            int v = order.pop();
            if (visited[v]) {
                DFS(v, visited);
                count++;
            }
        }

        return count;
    }

    private static ArrayList<Integer>[] reverseGraph() {
        // create array of arraylist same size as original graph
        ArrayList<Integer>[] revGraph = new ArrayList[adj.length];
        for (int v = 0; v < adj.length; v++)
            revGraph[v] = new ArrayList<>();
        // read original graph and reverse the direction
        for (int v = 0; v < adj.length; v++)
            for (int u : adj[v])
                revGraph[u].add(v);
        // return reversed graph
        return revGraph;
    }

    private static void DFS(int v, boolean[] visited) {
        // mark vertex as visited
        visited[v] = false;
        // search other connected vertices
        for (int u : adj[v])
            if (visited[u])
                DFS(u, visited);
    }

    private static void reverseDFS(int v, boolean[] visited, Stack<Integer> order, ArrayList<Integer>[] revGraph) {
        // mark vertex as visited
        visited[v] = true;
        // search other connected vertices
        for (int u : revGraph[v])
            if (!visited[u])
                reverseDFS(u, visited, order, revGraph);
        // push topological order of the vertices into stack
        order.push(v);
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
        }
        System.out.println(numberOfStronglyConnectedComponents());
    }
}
