import java.util.*;

public class GCD {

    // Naive GCD calculation - O(a) time where a < b or vise versa
    private static int naiveGCD(int a, int b) {
        int current_gcd = 1;
        for(int d = 2; d <= a && d <= b; ++d) {
            if (a % d == 0 && b % d == 0) {
                if (d > current_gcd) {
                    current_gcd = d;
                }
            }
        }
        return current_gcd;
    }

    // GCD calculated using a recursive call and mod operator
    public static int calcGCD(int a, int b) {
        // if a is divisable by b, than return b as the GCD
        if (a % b == 0)
            return b;
        else return calcGCD(b, a % b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(calcGCD(a, b));
    }
}
