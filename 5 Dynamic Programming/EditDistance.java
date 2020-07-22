import java.util.*;

class EditDistance {
    private static int calcDistance(String s, String t) {

        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
        //for (int[] d : dp)
        //    System.out.println(Arrays.toString(d));
        return dp[m][n];

        /*
        int count = 0, i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; j++; continue;
            } else if (j+1 < t.length() && s.charAt(i) == t.charAt(j+1)) {
                i++; j += 2;
            } else if (i+1 < s.length() && s.charAt(i+1) == t.charAt(j)) {
                i += 2; j++;
            } else {
                i++; j++;
            }
            count++;
        }
        while (j++ < t.length()) count++;
        while (i++ < s.length()) count++;

        return count;
        */
    }

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(calcDistance(s, t));
  }

}
