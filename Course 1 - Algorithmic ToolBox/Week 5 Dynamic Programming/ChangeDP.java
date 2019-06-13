import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        // Build array of least number of coins
        int[] change = new int[Math.max(m+1, 5)];
        change[0] = 0;
        change[1] = 1;
        change[2] = 2;
        change[3] = 1;
        change[4] = 1;
        for (int i = 5; i < m + 1; i++) {
            int min = change[i-1];
            min = Math.min(min, Math.min(change[i-3], change[i-4]));
            change[i] = min + 1;
        }
        // Returns value of least number of coins for a particular value.
        return change[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
