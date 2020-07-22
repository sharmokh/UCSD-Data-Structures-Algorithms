import java.util.*;

public class LCS2 {

    private static int lcs2(int[] A, int[] B) {
        // Dynamic Programming
        int a = A.length, b = B.length;
        int[][] dp = new int[a + 1][b + 1];
        for (int i = 0; i <= a; i++)
            for (int j = 0; j <= b; j++)
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (A[i-1]==B[j-1])
                    dp[i][j] = dp[i-1][j-1] +1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        return dp[a][b];
        // Recursive Method
        //return lcs(A, B, A.length, B.length);
    }

    private static int lcs(int[] A, int[] B, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        else if (A[m-1] == B[n-1])
            return 1 + lcs(A, B, m-1, n-1);
        else return Math.max(lcs(A,B,m-1,n), lcs(A,B,m,n-1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}
