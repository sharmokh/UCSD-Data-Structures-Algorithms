import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class ProcessPackages {
    private static ArrayList<Request> readQueries(Scanner scanner) throws IOException {
        int requestsCount = scanner.nextInt();
        ArrayList<Request> requests = new ArrayList<Request>();
        for (int i = 0; i < requestsCount; ++i) {
            int arrivalTime = scanner.nextInt();
            int processTime = scanner.nextInt();
            requests.add(new Request(arrivalTime, processTime));
        }
        return requests;
    }

    private static ArrayList<Response> processRequests(ArrayList<Request> requests, Buffer buffer) {
        ArrayList<Response> responses = new ArrayList<Response>();
        for (int i = 0; i < requests.size(); ++i) {
            responses.add(buffer.process(requests.get(i)));
        }
        return responses;
    }

    private static void printResponses(ArrayList<Response> responses) {
        for (int i = 0; i < responses.size(); ++i) {
            Response response = responses.get(i);
            if (response.dropped) {
                System.out.println(-1);
            } else {
                System.out.println(response.startTime);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int bufferMaxSize = scanner.nextInt();
        Buffer buffer = new Buffer(bufferMaxSize);

        ArrayList<Request> requests = readQueries(scanner);
        ArrayList<Response> responses = processRequests(requests, buffer);
        printResponses(responses);
    }
}

class Request {
    public Request(int arrivalTime, int processTime) {
        this.arrivalTime = arrivalTime;
        this.processTime = processTime;
    }

    public int arrivalTime;
    public int processTime;
}

class Response {
    public Response(boolean dropped, int startTime) {
        this.dropped = dropped;
        this.startTime = startTime;
    }

    public boolean dropped;
    public int startTime;
}

class Buffer {
    private int size;
    private ArrayList<Integer> finishTime;

    public Buffer(int size) {
        this.size = size;
        this.finishTime = new ArrayList<Integer>();
    }

    public Response process(Request request) {
        // write your code here
        return new Response(false, -1);
    }
}
