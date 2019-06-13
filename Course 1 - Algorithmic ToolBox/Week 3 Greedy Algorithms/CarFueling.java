import java.util.*;
import java.io.*;

public class CarFueling {

    // Starting from destiation, subtract the maximum distance stop before tank runs empty
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int minRefills = 0, i = stops.length - 1;
        while (dist - tank > 0) {
            if (dist - stops[i] > tank) return -1;
            while (i >= 0 && dist - tank <= stops[i])
                i--;
            minRefills++;
            dist = stops[i + 1];
        }
        return minRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
