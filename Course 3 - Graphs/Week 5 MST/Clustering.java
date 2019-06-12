import java.util.*;

public class Clustering {

    private static Point[] points;

    private static class Point {
        int x;
        int y;
        int index;

        public Point(int x, int y, int i) {
            this.x = x;
            this.y = y;
            index = i;
        }
    }

    private static class Edge {
        Point A;
        Point B;
        double dist;

        public Edge(Point A, Point B) {
            this.A = A;
            this.B = B;
            dist = calcDist();
        }

        private double calcDist() {
            return Math.sqrt(Math.pow(A.x - B.x,2) + Math.pow(A.y - B.y, 2));
        }
    }

    // Kruskal's Algorithm used to find minimum distance
    private static double clustering(int k) {
        double result = 0.;
        int n = points.length;
        Queue<Edge> edges = new PriorityQueue<>(new Comparator<Edge>(){
            @Override
            public int compare(Edge A, Edge B){
                return A.dist < B.dist ? -1 : 1;
            }
        });
        int[] mst = new int[n];

        for (int i = 0; i < n - 1; i++) {
            mst[i+1] = i+1;
            for (int j = i + 1; j < n; j++)
                edges.add(new Edge(points[i], points[j]));
        }

        while (n >= k) {
            Edge e = edges.remove();
            Point a = e.A; Point b = e.B;
            if (mst[a.index] != mst[b.index]) {
                int index = mst[b.index];
                for (int i = 0; i < mst.length; i++)
                    mst[i] = mst[i] == index ? mst[a.index] : mst[i];
                n--; result = e.dist;
                // System.out.println(b.index + " -> " + a.index + " : " + Arrays.toString(mst) + " - " + e.dist);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points[i] = new Point(x, y, i);
        }
        int k = scanner.nextInt();
        System.out.println(clustering(k));
    }
}
