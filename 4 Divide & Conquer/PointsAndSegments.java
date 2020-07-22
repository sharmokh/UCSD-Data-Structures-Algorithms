import java.util.*;

public class PointsAndSegments {

    static class Segment {
        int start;
        int end;
        public Segment(int s, int e) {
            start = s;
            end = e;
        }
    }

    private static int[] countSegments(int[] starts, int[] ends, int[] points) {

        Queue<Integer> s = new PriorityQueue<>();
        for (int start : starts)
            s.add(start);

        Queue<Integer> e = new PriorityQueue<>();
        for (int end : ends)
            e.add(end);

        // Correct answer if points are sorted.
        int[] cnt = new int[points.length];
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            while (!s.isEmpty() && s.peek() <= points[i]) {
                s.remove();
                count++;
            }
            while (!e.isEmpty() && e.peek() < points[i]) {
                e.remove();
                count--;
            }
            cnt[i] = count;
        }

        return cnt;
    }


    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = countSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}
