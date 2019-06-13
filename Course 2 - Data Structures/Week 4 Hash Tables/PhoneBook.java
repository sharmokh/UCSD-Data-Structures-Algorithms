import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class PhoneBook {

    private FastScanner in = new FastScanner();
    // Keep list of all existing (i.e. not deleted yet) contacts.
    // private List<Contact> contacts = new ArrayList<>();
    private Map<Integer, Contact> numMap = new HashMap<>();
    private Map<String, Contact> nameMap = new HashMap<>();

    public static void main(String[] args) {
        new PhoneBook().processQueries();
    }

    private Query readQuery() {
        String type = in.next();
        int number = in.nextInt();
        if (type.equals("add")) {
            String name = in.next();
            return new Query(type, name, number);
        } else {
            return new Query(type, number);
        }
    }

    private void writeResponse(String response) {
        System.out.println(response);
    }


    private void processQuery(Query query) {
        if (query.type.equals("add")) {
            // if we already have contact with such number,
            // we should rewrite contact's name
            if (numMap.containsKey(query.number)) {
                Contact contact = numMap.get(query.number);
                String name = contact.name;
                contact.name = query.name;
                nameMap.remove(name);
                nameMap.put(contact.name, contact);
            } else {
                Contact contact = new Contact(query.name, query.number);
                numMap.put(contact.number, contact);
                nameMap.put(contact.name, contact);
            }
        } else if (query.type.equals("del")) {
            if (numMap.containsKey(query.number)) {
                Contact contact = numMap.get(query.number);
                numMap.remove(contact.number);
                nameMap.remove(contact.name);
              }
        } else {
            if (numMap.containsKey(query.number))
                writeResponse(numMap.get(query.number).name);
            else writeResponse("not found");
        }
    }

    public void processQueries() {
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i)
            processQuery(readQuery());
    }

    static class Contact {
        String name;
        int number;

        public Contact(String name, int number) {
            this.name = name;
            this.number = number;
        }
    }

    static class Query {
        String type;
        String name;
        int number;

        public Query(String type, String name, int number) {
            this.type = type;
            this.name = name;
            this.number = number;
        }

        public Query(String type, int number) {
            this.type = type;
            this.number = number;
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
