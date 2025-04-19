import java.util.EmptyStackException;
import java.util.Stack;

public class ExprTree {
    private static class Node {
        char op; // operator or operand
        Node left;
        Node right;

        /**
         * A parameterized constructor for Node
         *
         * @param op the operand or operator field
         * @param left the left child of the subtree
         * @param right the right child of the subtree
         */
        Node(char op, Node left, Node right) {
            this.op = op;
            this.left = left;
            this.right = right;
        }

        /**
         * A parameterized constructor for Node
         *
         * @param op the operand or operator field
         */
        Node(char op) {
            this(op, null, null);
        }
    }

    /**
     * Convert a postfix expression to infix expression
     *
     * @param line a postfix expression to be converted
     * @return the infix expression generated from the postfix expression
     */
    public static String postFixToInfix(String line) {
        // generate an expression tree of the postfix expression
        Stack<Node> s = new Stack<>();
        int len = line.length();
        for(int i = 0; i < len; i++) {
            char c = line.charAt(i);
            if(c == '+' || c == '-' || c == '*' || c == '/') {
                Node op1, op2;
                try {
                    op2 = s.pop();
                    op1 = s.pop();
                } catch (EmptyStackException e) {
                    System.out.println("The stack is empty, nothing to be popped");
                    return null;
                }
                Node newNode = new Node(c, op1, op2);
                s.push(newNode);
            } else if (c == ' ') {
                continue;
            } else {
                Node newNode = new Node(c);
                s.push(newNode);
            }
        }
        Node tree = s.pop();

        // traverse the expression tree to get the infix expression
        return inOrderTraverse(tree);
    }

    /**
     * Inorder traverse the tree to print out the infix expression
     *
     * @param root root of the tree
     * @return the infix expression
     */
    public static String inOrderTraverse(Node root) {
        return inOrderTraverse(root, "");
    }

    /**
     * A helper method that generate an infix expression
     *
     * @param root the current root of the expression tree to be evaluated
     * @param expr the previous expression
     * @return the new expression by traverse the current tree
     */
    private static String inOrderTraverse(Node root, String expr) {
        if(root == null) {
            return "";
        }

        // if the root contains an operator, then add brackets to its left and right
        boolean addBrackets = false;
        if(root.op == '+' || root.op == '-' || root.op == '*' || root.op == '/') {
            addBrackets = true;
        }

        // construct the tree by inorder traverse
        if(addBrackets) {
            expr += '(';
        }
        expr += inOrderTraverse(root.left, "");
        expr += root.op;
        expr += inOrderTraverse(root.right, "");
        if(addBrackets) {
            expr += ')';
        }

        return expr;
    }

    /**
     * Convert an infix expression to postfix using stack (it may contain brackets)
     *
     * @param line the infix expression to be converted
     * @return the postfix expression
     */
    public static String infixToPostfix(String line) {
        int len = line.length();
        String output = "";
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                // if it's a number, write to the output
                output += c;
            } else if (c == '+' || c == '-') {
                while (!s.isEmpty() && s.peek() != '(') {
                    // output the operator that has equal or higher priority except (
                    output += s.pop();
                }
                // push the operator onto the stack
                s.push(c);
            } else if (c == '*' || c == '/') {
                char popped;
                while (!s.isEmpty() && ((popped = s.peek()) != '+')
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
                while (!s.isEmpty() && s.peek() != '(') {
                    popped = s.pop();
                    output += popped;
                }
                if (s.peek() == '(') {
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

    public static void main(String[] args) {
        String newInfix = postFixToInfix(" a b + c d e + * *");
        System.out.println(newInfix);
    }
}
