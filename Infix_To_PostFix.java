import java.util.Stack;

public class Infix_To_PostFix {
    public static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public static String convert(String str) {
        String res = new String("");
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                res += c;
            } else if (c == '(') {
                s.push(c);
            } else if (c == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    res += s.pop();
                }
                s.pop();
            } else {
                while (!s.isEmpty() && precedence(c) < precedence(s.peek())) {
                    res += s.pop();
                }
                s.push(c);
            }
        }
        while (!s.isEmpty()) {
            if (s.peek() == '(') {
                return "Invalid Expression";
            }
            res += s.pop();
        }
        return res;
    }

    public static void main(String args[]) {
        String str = "a+b*(6+8)-q^t*5+(1-2)+s";
        String ans = convert(str);
        System.out.println(ans);
    }

}
