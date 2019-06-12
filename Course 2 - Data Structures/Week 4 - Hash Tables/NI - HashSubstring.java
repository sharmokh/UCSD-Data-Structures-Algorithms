import java.io.*;
import java.util.*;

public class HashSubstring {

    private static FastScanner in;
    private static PrintWriter out;
    private static int prime = 1000000007;
    private static int mult = 263;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        printOccurrences(getOccurrences(readInput()));
        out.close();
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurrences(List<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }

    private static List<Integer> getOccurrences(Data input) {

        String p = input.pattern, t = input.text;
        int m = p.length(), n = t.length();
        long pHash = 0, tHash = 0, y = 1;
        List<Integer> occurrences = new ArrayList<Integer>();

        for (int i = m - 1; i >= 0; i--) {
            pHash = (pHash * mult + p.charAt(i)) % prime;
            y = y * mult % prime;
        }
        for (int i = n - 1; i >= n - m; i--)
            tHash = (tHash * mult + t.charAt(i)) % prime;
        if (tHash == pHash && p.equals(t.substring(n-m, n)))
            occurrences.add(n-m);

        for (int i = n - m - 1; i >= 0; i--) {
    	    tHash = ((tHash * mult + t.charAt(i) - t.charAt(i+m) * y) % prime + prime) % prime;
    	    if (tHash == pHash && p.equals(t.substring(i, i+m)))
                occurrences.add(0,i);
	    }

        return occurrences;
    }

    static class Data {
        String pattern;
        String text;
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
