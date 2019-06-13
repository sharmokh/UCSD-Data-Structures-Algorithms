import java.util.*;

public class FibonacciPartialSum {

    // Naive method runtime O(n) iterativing from 0 to final number (to)
    private static long naiveFibPartialSum(long from, long to) {
        long sum = 0;
        long current = 0;
        long next  = 1;
        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }
            long new_current = next;
            next = next + current;
            current = new_current;
        }
        return sum % 10;
    }

    public static long calcFibPartSum(long from, long to) {
        from = from == 0 ? 1 : from;
        long result = calcFibSum(to) - calcFibSum(from - 1);
        return result < 0 ? 10 + result : result;
    }

    public static long calcFibSum(long n) {
        n = n % 60;
        return calcFibSumHelper(n, 1);
    }

    private static long calcFibSumHelper(long n, long power) {
        if (n <= 1)
            return n;
        long previous = 0;
        long current  = 1;
        long sum      = 1;
        for (long i = 0; i < n-1; ++i) {
            long temp = previous;
            previous = current;
            current = (temp + (long) Math.pow(current, power)) % 10;
            sum = (sum + current) % 10;
        }
        return (long) sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(calcFibPartSum(from, to));
    }
}
