import java.util.*;
import java.io.*;

public class is_bst_hard {
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

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;
        List<Integer> inOrder;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            inOrder = new ArrayList<>();
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
            if (nodes != 0)
                inOrderTraversal(0);
        }

        void inOrderTraversal(int i) {
            if (i == -1) return;
            Node current = tree[i];
            inOrderTraversal(current.left);
            inOrder.add(i);
            inOrderTraversal(current.right);
        }

        boolean isBinarySearchTree() {
            if (tree.length < 2) return true;

            // Using in order traversal check to make sure the left is smaller than the right
            // If equal, check to make sure that the left is not left child of the right
            for (int i = 1; i < inOrder.size(); i++) {
                Node left = tree[inOrder.get(i-1)];
                Node right = tree[inOrder.get(i)];
                if (left.key > right.key)
                    return false;
                else if (left.key == right.key && right.left == inOrder.get(i-1))
                    return false;
            }

            return true;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst_hard().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
