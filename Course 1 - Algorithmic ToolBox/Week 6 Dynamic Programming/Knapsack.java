import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        int n = w.length;
        int[][] sack = new int[n+1][W+1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= W; j++)
                if (i == 0 || j == 0)
                    sack[i][j] = 0;
                else {
                    sack[i][j] = sack[i-1][j];
                    if (w[i-1] <= j) {
                        int val = sack[i-1][j-w[i-1]] + w[i-1];
                        sack[i][j] = Math.max(sack[i][j], val);
                    }
                }

        return sack[n][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}
