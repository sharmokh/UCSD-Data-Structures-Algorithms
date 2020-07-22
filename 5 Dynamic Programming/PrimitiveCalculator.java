import java.util.*;

public class PrimitiveCalculator {
    // Find solution based Greedy Algorithm.  Does not optimize number of operations.
    private static List<Integer> greedyCalculator(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    private static List<Integer> optimalSequence(int n) {
        // Build array of optimal number of operations.
        int[] A = new int[n+1];
        A[1] = 0;
        for (int i = 2; i < n+1; i++) {
            A[i] = A[i-1] + 1;
            if (i % 2 == 0) A[i] = Math.min(A[i], A[i/2]+1);
            if (i % 3 == 0) A[i] = Math.min(A[i], A[i/3]+1);
        }

        // Find optimal path using array of optimal number of operations.
        List<Integer> sequence = new ArrayList<>();
        while (n > 1) {
            sequence.add(n);
            if (A[n-1] == A[n] - 1)
                n -= 1;
            else if (n % 2 == 0 && A[n/2] == A[n] - 1)
                n /= 2;
            else n /= 3;
        }
        sequence.add(1);
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimalSequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}
