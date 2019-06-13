import java.util.*;

public class LCS3 {

    private static int lcs3(int[] A, int[] B, int[] C) {
        int a = A.length, b = B.length, c = C.length;
        int[][][] dp = new int[a + 1][b + 1][c + 1];
        for (int i = 0; i <= a; i++)
            for (int j = 0; j <= b; j++)
                for (int k = 0; k <= c; k++)
                    if (i == 0 || j == 0 || k == 0)
                        dp[i][j][k] = 0;
                    else if (A[i-1] == B[j-1] && A[i-1] == C[k-1])
                        dp[i][j][k] = dp[i-1][j-1][k-1] +1;
                    else
                        dp[i][j][k] = Math.max(dp[i][j][k-1], Math.max(dp[i-1][j][k], dp[i][j-1][k]));
        return dp[a][b][c];

        // Recursive Method
        //return lcs(A, B, C, A.length, B.length, C.length);
    }

    private static int lcs(int[] A, int[] B, int[] C, int a, int b, int c) {
        if (a == 0 || b == 0 || c == 0) {
            return 0;
        } else if (A[a-1] == B[b-1] && A[a-1] == C[c-1]) {
            return 1 + lcs(A, B, C, a-1, b-1, c-1);
        } else {
            return Math.max(lcs(A,B,C,a-1,b,c), Math.max(lcs(A,B,C,a,b-1,c), lcs(A,B,C,a,b,c-1)));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}
