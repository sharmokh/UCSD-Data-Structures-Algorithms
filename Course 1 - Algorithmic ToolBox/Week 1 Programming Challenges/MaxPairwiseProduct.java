import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {

    static int getMaxPairwiseProductNaive(int[] numbers) {
        int max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = max(max_product,
                    numbers[first] * numbers[second])
            }
        }

        return max_product;
    }

    static long getMaxPairwiseProduct(int[] nums) {

        if (nums.length < 2) return 0;
        int maxOne = nums[0];
        int maxTwo = nums[0];
        if (nums[1] > nums[0]) maxOne = nums[1];
        else maxTwo = nums[1];
        for (int i = 2; i < nums.length; i++)
          if (nums[i] > maxTwo)
            if (nums[i] > maxOne) {
              maxTwo = maxOne;
              maxOne = nums[i];
            } else maxTwo = nums[i];

        return (long) maxOne * maxTwo;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
