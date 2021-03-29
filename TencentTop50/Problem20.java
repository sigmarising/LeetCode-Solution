package TencentTop50;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem20 {
    private Map<Character, Character> map = new HashMap<Character, Character>() {{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

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
                case ']':
                case '}':
                    if (!stack.isEmpty() && stack.peek() == map.get(c)) stack.pop();
                    else return false;
                    break;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Problem20 p = new Problem20();
        p.isValid("()");
    }
}
