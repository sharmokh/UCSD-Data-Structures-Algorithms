import java.util.*;
import java.io.*;

public class MajorityElement {
    /* Recursive Method
    private static int getMajorityElement(int[] a, int left, int right) {
        // 2 3 9 2 2
        // ((L = 2  R = 3) && R = 9) && (L = 9  R = 2)

        if (left == right) return a[left];
        int k = (left + right) / 2;
        int lElement = getMajorityElement(a, left, k);
        int rElement = getMajorityElement(a, k + 1, right);

        if (lElement == rElement)
            return lElement;
        else if (getFrequency(a, lElement) > a.length / 2)
            return lElement;
        else if (getFrequency(a, rElement) > a.length / 2)
            return rElement;
        else return -1;
    }
    */
    private static int getMajorityElement(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A)
            map.put(a, map.getOrDefault(a, 0) + 1);
        int k = A.length / 2;
        for (int key : map.keySet())
            if (map.get(key) > k) return key;
        return -1;
    }

    private static int getFrequency(int[] A, int x) {
        int count = 0;
        for (int a : A)
            count += a == x ? 1 : 0;
        //System.out.println(x + ": "  + count);
        return count;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        // System.out.println(getMajorityElement(a, 0, a.length-1));
        if (getMajorityElement(a) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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
