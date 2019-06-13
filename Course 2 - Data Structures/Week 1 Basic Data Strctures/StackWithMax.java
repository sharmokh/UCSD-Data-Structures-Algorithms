import java.util.*;
import java.io.*;

public class StackWithMax {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    class MaxStack {
        Stack<Integer> stack;
        int max;

        MaxStack() {
            stack = new Stack<>();
        }

        void push(int n) {
            if (stack.isEmpty()){
                max = n;
                stack.add(n);
            } else if (n <= max)
                stack.add(n);
            else {
                stack.add(n*2 - max);
                max = n;
            }
        }

        int max() {
            return max;
        }

        int pop() {
            if (stack.isEmpty())
                return -1;
            else if (stack.peek() <= max)
                return stack.pop();
            else {
                int p = stack.pop();
                int n = max;
                max = 2*n - p;
                return n;
            }
        }
    }

    public void solve() throws IOException {
        FastScanner scanner = new FastScanner();
        int queries = scanner.nextInt();
        MaxStack stack = new MaxStack();

        for (int qi = 0; qi < queries; ++qi) {
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
                stack.push(value);
            } else if ("pop".equals(operation)) {
                stack.pop();
            } else if ("max".equals(operation)) {
                System.out.println(stack.max());
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }
}
