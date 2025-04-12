public class ExprEval {
    public static String infixToPostFix(String line) {
        int len = line.length();
        String output = "";
        AStack<Character> s = new AStack<>(len);
        for (int i = 0; i < len; i++) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                output += c;
            } else if (c == '+' || c == '-') {
                while (!s.isEmpty() && s.top() != '(') {
                    output += s.pop();
                }
                s.push(c);
            } else if (c == '*' || c == '/') {
                char popped;
                while (!s.isEmpty() && ((popped = s.top()) != '+')
                        && popped != '-' && popped != '(') {
                    popped = s.pop();
                    output += popped;
                }
                s.push(c);
            } else if (c == '(') {
                s.push(c);
            } else if (c == ')') {
                char popped;
                while (!s.isEmpty() && s.top() != '(') {
                    popped = s.pop();
                    output += popped;
                }
            } else if (Character.isAlphabetic(c)) {
                System.out.println("Invalid character: " + c);
                return null;
            }
        }
        while (!s.isEmpty()) {
            output += s.pop();
        }
        return output;
    }

    public static void evalExpr(String line) {
        int len = line.length();
        AStack<Integer> s = new AStack<>(len);
        for (int i = 0; i < len; i++) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                s.push(c - '0');
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                int op1 = s.pop();
                int op2 = s.pop();
                if (String.valueOf(op1) == null || String.valueOf(op2) == null) {
                    System.out.println("Expression invalid, not enough operands");
                    return;
                }
                if (c == '+') {
                    s.push(op1 + op2);
                } else if (c == '-') {
                    s.push(op1 - op2);
                } else if (c == '*') {
                    s.push(op1 * op2);
                } else if (c == '/') {
                    s.push(op1 / op2);
                }
            }
        }
        System.out.println(s.top());
    }

    public static void main(String[] args) {
        String line = infixToPostFix("(1 + 2) * 3 + (4 * (5 + 6)) * 7");
        if (line == null) {
            return;
        }
        evalExpr(line);
    }
}
