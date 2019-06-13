import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition3(int[] A) {
        int sum = 0;
        for (int a : A)
            sum += a;
        if (sum % 3 != 0) return 0;

        int m = sum / 3 + 1, n = A.length;
        int[][] partitions = new int[n+1][m+1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                if (i == 0 || j == 0)
                    partitions[i][j] = 0;
                else {
                    partitions[i][j] = partitions[i-1][j];
                    if (A[i-1] <= j) {
                        int val = partitions[i-1][j-A[i-1]] + A[i-1];
                        partitions[i][j] = Math.max(partitions[i][j], val);
                    }
                }
        return partitions[n][sum/3] == sum/3 ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}
