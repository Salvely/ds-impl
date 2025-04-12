import java.util.Scanner;

public class BracketBalance {
    public static void aStackTest() {
        System.out.print("Enter a line of input: ");
        Scanner input = new Scanner(System.in);
        String line;
        while ((line = input.nextLine()) != "") {
            AStack<Character> s = new AStack<>(line.length());
            int len = line.length();
            for (int i = 0; i < len; i++) {
                char c = line.charAt(i);
                if (c == '{' || c == '[' || c == '(') {
                    s.push(c);
                } else if (c == '}' || c == ']' || c == ')') {
                    char bracket = s.pop();
                    if (c == '}' && bracket != '{') {
                        System.out.println("No matching bracket for }");
                        return;
                    } else if (c == ']' && bracket != '[') {
                        System.out.println("No matching bracket for ]");
                        return;
                    } else if (c == ')' && bracket != '(') {
                        System.out.println("No matching bracket for )");
                        return;
                    } else if (String.valueOf(bracket) == null) {
                        System.out.println("Missing open brackets.");
                        return;
                    }
                }
            }
            if (!s.isEmpty()) {
                System.out.println("Missing close brackets.");
                return;
            } else {
                System.out.println(line + ": Brackets balanced.");
                System.out.print("Enter a line of input: ");
            }
        }
    }

    public static void lStackTest() {
        System.out.print("Enter a line of input: ");
        Scanner input = new Scanner(System.in);
        String line;
        while ((line = input.nextLine()) != "") {
            LStack<Character> s = new LStack<>();
            int len = line.length();
            for (int i = 0; i < len; i++) {
                char c = line.charAt(i);
                if (c == '{' || c == '[' || c == '(') {
                    s.push(c);
                } else if (c == '}' || c == ']' || c == ')') {
                    char bracket = s.pop();
                    if (c == '}' && bracket != '{') {
                        System.out.println("No matching bracket for }");
                        return;
                    } else if (c == ']' && bracket != '[') {
                        System.out.println("No matching bracket for ]");
                        return;
                    } else if (c == ')' && bracket != '(') {
                        System.out.println("No matching bracket for )");
                        return;
                    } else if (String.valueOf(bracket) == null) {
                        System.out.println("Missing open brackets.");
                        return;
                    }
                }
            }
            if (!s.isEmpty()) {
                System.out.println("Missing close brackets.");
                return;
            } else {
                System.out.println(line + ": Brackets balanced.");
                System.out.print("Enter a line of input: ");
            }
        }
    }

    public static void main(String[] args) {
        aStackTest();
        lStackTest();
    }
}
