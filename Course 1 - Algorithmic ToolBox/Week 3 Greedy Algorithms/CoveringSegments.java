import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {

        Arrays.sort(segments, new Comparator<Segment>(){
            public int compare(Segment A, Segment B) {
                return A.end - B.end;
            }
        });

        List<Integer> points = new ArrayList<>();
        int i = 0;
        while (i < segments.length) {
            int point = segments[i].end;
            points.add(point);
            while (i < segments.length &&
                   point >= segments[i].start &&
                   point <= segments[i].end)
                i++;
        }

        return points.stream().mapToInt(j -> j).toArray();
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
