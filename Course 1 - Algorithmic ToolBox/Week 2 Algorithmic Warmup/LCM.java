import java.util.*;

public class LCM {

    // Naive LCM implementation in O(a * b) time
    private static long naiveLCM(int a, int b) {
        for (long l = 1; l <= (long) a * b; ++l)
            if (l % a == 0 && l % b == 0)
                return l;
        return (long) a * b;
    }

    // Faster method is to multiple a and b and divide by the greatest common factor
    public static long calcLCM(int a, int b) {
        int gcd = calcGCF(a, b);
        return (long) a * b / gcd;
    }

    // GCF calculated using a recursive call and mod operator
    public static int calcGCF(int a, int b) {
        // if a is divisable by b, than return b as the GCF
        if (a % b == 0)
            return b;
        else return calcGCF(b, a % b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(calcLCM(a, b));
    }
}
