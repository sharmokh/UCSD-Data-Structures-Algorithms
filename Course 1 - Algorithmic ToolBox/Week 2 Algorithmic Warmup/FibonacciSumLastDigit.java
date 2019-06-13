import java.util.*;

public class FibonacciSumLastDigit {
    private static long naiveFibSum(long n) {
        if (n <= 1)
            return n;
        long previous = 0;
        long current  = 1;
        long sum      = 1;
        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }
        return sum % 10;
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
        long n = scanner.nextLong();
        long s = calcFibSum(n);
        System.out.println(s);
    }
}
