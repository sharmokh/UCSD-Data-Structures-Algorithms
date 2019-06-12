import java.util.*;

public class ShortestPaths {
    public static ArrayList<Integer>[] adj;
    public static ArrayList<Integer>[] cost;

    private static void shortestPaths(int s, long[] distance, int[] reachable, int[] shortest) {

        int n = distance.length;

        // initial start distance and reachability of vertex
        distance[s] = 0;
        reachable[s] = 1;

        // loop n - 1 times for Bellman-Ford Algorithm
        // and nth time to determine negative cycle
        // mark and calculate distance reachable from the start
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            Queue<Integer> vQueue = new LinkedList<>();
            vQueue.add(s);
            while (!vQueue.isEmpty()) {
                int v = vQueue.remove();
                if (!visited[v])
                    for (int j = 0; j < adj[v].size(); j++) {
                        int u = adj[v].get(j);
                        int c = cost[v].get(j);
                        reachable[u] = 1;
                        // relax method if distance can be improved
                        if (distance[u] > distance[v] + c) {
                            distance[u] = distance[v] + c;
                            // check for negative cycle at nth time
                            if (i == n-1) shortest[u] = 0;
                        }
                        vQueue.add(u);
                    }
                visited[v] = true;
            }
        }
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
        int s = scanner.nextInt() - 1;
        long distance[] = new long[n];
        int reachable[] = new int[n];
        int shortest[] = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Long.MAX_VALUE;
            reachable[i] = 0;
            shortest[i] = 1;
        }
        shortestPaths(s, distance, reachable, shortest);
        for (int i = 0; i < n; i++) {
            if (reachable[i] == 0) {
                System.out.println('*');
            } else if (shortest[i] == 0) {
                System.out.println('-');
            } else {
                System.out.println(distance[i]);
            }
        }
    }

}
