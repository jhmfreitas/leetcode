package blind75.easy;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        if(s.length()%2!=0)
            return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty())
                    return false;

                char topCharacter = stack.peek();
                if(c == ')' && topCharacter == '(') {
                    stack.pop();
                } else if (c == '}' && topCharacter == '{') {
                    stack.pop();
                } else if (c == ']' && topCharacter == '[') {
                    stack.pop();
                } else {
                    break;
                }
            }
        }

        return stack.empty();
    }
}
