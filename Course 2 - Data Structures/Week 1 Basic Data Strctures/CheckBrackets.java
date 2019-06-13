import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class CheckBrackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> openingBracketsStack = new Stack<Bracket>();
        boolean checkBracket = true; int i = 0;
        while (checkBracket && i < text.length()) {
            char next = text.charAt(i);
            if (next == '(' || next == '[' || next == '{')
                openingBracketsStack.push(new Bracket(next, i+1));
            else if (next == ')' || next == ']' || next == '}') {
                if (openingBracketsStack.isEmpty()) {
                    System.out.println(i+1);
                    checkBracket = false;
                } else {
                    Bracket last = openingBracketsStack.pop();
                    if (!last.match(next)) {
                        System.out.println(i+1);
                        checkBracket = false;
                    }
                }
            }
            i++;
        }

        if (checkBracket)
            if (openingBracketsStack.isEmpty())
                System.out.println("Success");
            else
                System.out.println(openingBracketsStack.pop().position);
    }
}
