import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        Arrays.sort(a, new Comparator<String>(){
            public int compare(String a, String b) {
                int n = Math.max(a.length(), b.length());
                for (int i = 0; i < n; i ++) {
                    if (i >= a.length())
                        return b.charAt(i) - b.charAt(i-1);
                    if (i >= b.length())
                        return a.charAt(i-1) - a.charAt(i);
                    if (a.charAt(i) != b.charAt(i))
                        return b.charAt(i) - a.charAt(i);
                }
                return -1;
            }
        });

        String result = "";
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}
