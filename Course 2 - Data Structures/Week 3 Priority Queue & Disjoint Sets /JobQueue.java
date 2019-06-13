import java.io.*;
import java.util.*;

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    class Job {
        int thread;
        long duration;

        private Job(int t, long d) {
            thread = t;
            duration = d;
        }
    }

    class JobsComparator implements Comparator<Job> {
        public int compare(Job a, Job b) {
            if (a.duration == b.duration) return a.thread - b.thread;
            return (int) (a.duration - b.duration);
        }
    }

    private void assignJobs() {

        // Build Priority Queue
        Queue<Job> pQueue = new PriorityQueue<>(numWorkers, new JobsComparator());
        for (int i = 0; i < numWorkers; i++) {
            pQueue.add(new Job(i, 0));
        }

        // Process Jobs by Free Thread
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        for (int i = 0; i < jobs.length; i++) {
            Job j = pQueue.poll();
            assignedWorker[i] = j.thread;
            startTime[i] = j.duration;
            pQueue.add(new Job(j.thread, j.duration + jobs[i]));
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
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
