import java.util.*;

public class ShortestPaths {
    public static List<int[]> edges;

    private static void shortestPaths(int s, long[] distance, int[] reachable, int[] shortest) {

        int n = distance.length;
        // initial start distance and reachability of vertex
        distance[s] = 0;
        reachable[s] = 1;

        // loop n - 1 times for Bellman-Ford Algorithm
        // and nth time to determine negative cycle
        // mark and calculate distance reachable from the start
        for (int i = 0; i < n; i++)
            for (int[] edge : edges) {
                int v = edge[0];
                int u = edge[1];
                int c = edge[2];
                reachable[u] = 1;
                // System.out.println(u + " " + Arrays.toString(distance));
                if (distance[v] != Long.MAX_VALUE && distance[u] > distance[v] + c) {
                    distance[u] = distance[v] + c;
                    // check for negative cycle at nth time
                    if (i == n-1) shortest[u] = 0;
                }
            }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x, y, z;
            x = scanner.nextInt();
            y = scanner.nextInt();
            z = scanner.nextInt();
            edges.add(new int[] {x-1, y-1, z});
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
