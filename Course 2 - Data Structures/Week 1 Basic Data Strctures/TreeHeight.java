import java.util.*;
import java.io.*;

public class TreeHeight {
	static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new TreeHeight().run();
                } catch (IOException e) {}
            }
        }, "1", 1 << 26).start();
	}

	public void run() throws IOException {
		buildTree tree = new buildTree();
		Node head = tree.read();
		System.out.println(tree.computeHeight(head));
	}
}

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

class Node {
    int value;
    List<Node> children;

    Node(int n) {
        value = n;
        children = new ArrayList<>();
    }
}

class buildTree {

    Node read() throws IOException {
        FastScanner in = new FastScanner();
        int n = in.nextInt();
        Node head = null;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++)
            nodes[i] = new Node(i);
        for (int i = 0; i < n; i++) {
            int p = in.nextInt();
            if (p == -1)
                head = nodes[i];
            else {
                nodes[p].children.add(nodes[i]);
            }
        }
        return head;
    }

    int computeHeight(Node current) {
        if (current == null)
            return 0;
        else {
            int height = 1;
            if (!current.children.isEmpty()) {
                List<Integer> heights = new ArrayList<>();
                for (Node child : current.children)
                    heights.add(computeHeight(child));
                height = 1 + Collections.max(heights);
            }
            return height;
        }
    }
}
