import java.util.*;

public class FibonacciLastDigit {

    // Runtime O(n) iterating from 0 to n with possible integer overflow error
    private static int naiveFibLastDigit(int n) {
        if (n <= 1)
            return n;
        int previous = 0;
        int current  = 1;
        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }
        return current % 10;
    }

    // using previously implmented method calcFibHuge with m = 10 to get to single digit
    public static int calcFibLastDigit(int n) {
        return (int) calcFibHuge((long) n, (long) 10);
    }

    // Method reduces numer of calculations to 0(m^2) using Pisano Period
    private static long calcFibHuge(long n, long m) {
        n = n % calcPisanoPeriod(m);
        if (n <= 1) return n;
        long previous = 0;
        long current  = 1;
        for (long i = 0; i < n - 1; ++i) {
            long temp = previous;
            previous = current;
            current = (temp + current) % m;
        }
        return current;
    }

    // Pisano Period needed to take mod m of Fib n
    // https://en.wikipedia.org/wiki/Pisano_period
    private static long calcPisanoPeriod(long m) {
        long previous = 0;
        long current  = 1;
        for (long i = 1; i < m*m; ++i) {
            long temp = previous;
            previous = current;
            current = (temp + current) % m;
            if (previous == 0 && current == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = calcFibLastDigit(n);
        System.out.println(c);
    }
}
