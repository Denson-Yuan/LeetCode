/**
 * Valid Parentheses
 * 判断括号是否正确配对
 */
import java.util.Stack;

public class LC20 {
    public static void main(String[] args) {
        String s = "({()})()";
        System.out.println(new LC20().isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.empty() || stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (stack.empty() || stack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if (stack.empty() || stack.pop() != '{')
                        return false;
                    break;
            }
        }
        return stack.empty();
    }
}
