public class ExprEval {
    public static String infixToPostFix(String line) {
        int len = line.length();
        String output = "";
        AStack<Character> s = new AStack<>(len);
        for (int i = 0; i < len; i++) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                // if it's a number, write to the output
                output += c;
            } else if (c == '+' || c == '-') {
                while (!s.isEmpty() && s.top() != '(') {
                    // output the operator that has equal or higher priority except (
                    output += s.pop();
                }
                // push the operator onto the stack
                s.push(c);
            } else if (c == '*' || c == '/') {
                char popped;
                while (!s.isEmpty() && ((popped = s.top()) != '+')
                        && popped != '-' && popped != '(') {
                    // output the operator that has equal or higher priority except (
                    popped = s.pop();
                    output += popped;
                }
                // push the operator onto the stack
                s.push(c);
            } else if (c == '(') {
                // push the operator onto the stack
                s.push(c);
            } else if (c == ')') {
                char popped;
                // pop the operator on the stack until encounter (, pop the ( too
                while (!s.isEmpty() && s.top() != '(') {
                    popped = s.pop();
                    output += popped;
                }
                if (s.top() == '(') {
                    s.pop();
                }
            } else if (Character.isAlphabetic(c)) {
                System.out.println("Invalid character: " + c);
                return null;
            }
        }
        // pop the left operator on the stack
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
        String line = infixToPostFix("1 + 2 * 3 + (4 * 5 + 6) * 7");
        if (line == null) {
            return;
        }
        evalExpr(line);
    }
}
