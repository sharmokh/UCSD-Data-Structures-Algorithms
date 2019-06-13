import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] A, int[] B, int left, int right) {

        if (left + 1 >= right) return 0;
        long numberOfInversions = 0;
        int mid = (left + right) / 2;
        numberOfInversions = getNumberOfInversions(A, B, left, mid);
        numberOfInversions += getNumberOfInversions(A, B, mid, right);
        numberOfInversions += merge(A, B, left, mid, right);
        return numberOfInversions;
    }

    private static long merge(int[] A, int[] B, int left, int leftEnd, int rightEnd){
        long numberOfInversions = 0;
        int start = left, right = leftEnd, index = left;
        while (left < leftEnd && right < rightEnd) {
            if (A[left] <= A[right]) {
                B[index] = A[left];
                left++;
            } else {
                B[index] = A[right];
                right++; numberOfInversions += leftEnd - left;
            }
            index++;
        }
        while (left < leftEnd) {
            B[index] = A[left];
            left++;
        }
        while (right < rightEnd) {
            B[index] = A[right];
            right++;
        }
        for (int i = start; i < rightEnd; i++)
            A[i] = B[i];
        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        int[] B = new int[n];
        System.out.println(getNumberOfInversions(A, B, 0, A.length));
    }
}
