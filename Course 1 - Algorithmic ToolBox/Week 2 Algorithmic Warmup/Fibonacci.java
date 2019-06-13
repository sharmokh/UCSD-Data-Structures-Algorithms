import java.util.Scanner;

public class Fibonacci {
    // Naive implementation creates additional unnessary recursive stacks
    // O(2^n) run time, not using any previously obtained lower Fib values
    private static long naiveFib(int n) {
        if (n <= 1)
            return n;
        return naiveFib(n - 1) + naiveFib(n - 2);
    }

    // O(n) run time by storing previous and current values to calculate next values
    public static long calcFib(int n) {
        if (n <= 1) return n;
        long previous = 0;
        long current  = 1;
        // stores previous into a temp value, assigns previous the value of current
        // finally, calculate new current by adding the temp previous to itself
        for (long i = 0; i < n - 1; ++i) {
            long temp = previous;
            previous = current;
            current += temp;
        }
        return current;
    }


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(calcFib(n));
    }
}
