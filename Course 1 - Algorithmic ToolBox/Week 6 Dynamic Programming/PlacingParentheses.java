import java.util.*;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        int n = (exp.length() - 1) / 2;

        int[] values = getValues(exp, n);
        char[] symbols = getSymbols(exp, n);

        long[][] min = new long[n+1][n+1];
        long[][] max = new long[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            min[i][i] = (long) values[i];
            max[i][i] = (long) values[i];
        }

        for (int s = 1; s <= n; s++) {
            for (int i = 0; i <= n-s; i++) {
                int j = i + s;
                long mn = Long.MAX_VALUE;
                long mx = Long.MIN_VALUE;
                for (int k = i; k <= j-1; k++) {
                    long a = eval(max[i][k], max[k+1][j], symbols[k]);
                    long b = eval(max[i][k], min[k+1][j], symbols[k]);
                    long c = eval(min[i][k], max[k+1][j], symbols[k]);
                    long d = eval(min[i][k], min[k+1][j], symbols[k]);
                    mn = Math.min(mn, Math.min(Math.min(a, b), Math.min(c, d)));
                    mx = Math.max(mx, Math.max(Math.max(a, b), Math.max(c, d)));

                }
                min[i][j] = mn;
                max[i][j] = mx;
            }
        }

        return max[0][n];
    }

    private static int[] getValues(String s, int n) {
        int[] values = new int[n+1];
        for (int i = 0; i <= n; i++)
            values[i] = s.charAt(2*i) - '0';
        return values;
    }

    private static char[] getSymbols(String s, int n) {
        char[] symbols = new char[n];
        for (int i = 0; i < n; i++)
            symbols[i] = s.charAt(2*i+1);
        return symbols;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}
