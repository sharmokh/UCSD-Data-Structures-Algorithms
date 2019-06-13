import java.util.*;

public class FibonacciHuge {

    // Naive implementation of Fib Huge leads to overflow error
    private static long naiveFibHuge(long n, long m) {
        if (n <= 1)
            return n;
        long previous = 0;
        long current  = 1;
        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }
        return current % m;
    }

    // Method accounts for taking mod m early to avoid long overflow error
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
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(calcFibHuge(n, m));
    }
}
