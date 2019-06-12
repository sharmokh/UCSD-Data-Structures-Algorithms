import java.util.*;

public class Dijkstra {
    private static ArrayList<Integer>[] adj;
    private static ArrayList<Integer>[] cost;

    private static class Pair{
        int distance;
        int vertex;
        private Pair(int d, int v) {
            distance = d;
            vertex = v;
        }
    }

    private static int distance(int s, int t) {

        // create and initialize all distances to -1
        int[] dist = new int[adj.length];
        for (int i = 0; i < dist.length; i++)
            dist[i] = -1;

        // finds min distances from s to all vertices
        minPath(s, dist);
        // returns shortest distance to t
        return dist[t];
    }

    private static void minPath(int s, int[] dist) {

        // set start to 0 distance
        dist[s] = 0;
        // priority queue that stores distance and node that use distance as comparator
        Queue<Pair> pQueue = new PriorityQueue<Pair>(new Comparator<Pair>(){
            @Override
            public int compare(Pair A, Pair B){
                return A.distance - B.distance;
            }
        });

        // initialize priority queue and loops until empty
        pQueue.add(new Pair(dist[s], s));
        while (!pQueue.isEmpty()) {
            // obtains vertex with shortest distance in priority queue
            int v = pQueue.remove().vertex;
            // iterate throug all edges of that vertex
            for (int i = 0; i < adj[v].size(); i++) {
                int u = adj[v].get(i);
                int c = cost[v].get(i);
                // compares initial distance or previously stored distance of u with
                // distance up to v and cost of the edge - updates distance of u
                // and adds u to priority queue if such a smaller distance exists
                if (dist[u] == -1 || dist[u] > dist[v] + c) {
                    dist[u] = dist[v] + c;
                    pQueue.add(new Pair(dist[u], u));
                }
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(x, y));
    }
}
