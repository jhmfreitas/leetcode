package blind75.hard;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> characters = new Stack<>();

        // Initialize the sign as positive
        int sign = 1;
        // This will hold the final result of the evaluation
        int result = 0;
        // Length of the input string for iteration
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int start = i;
                int number = 0;

                while (start < length && Character.isDigit(s.charAt(start))) {
                    number = number * 10 + s.charAt(start) - '0';
                    start++;
                }

                // Update the result with the current number and sign
                result += sign * number;
                // Move the pointer to the end of the number
                i = start - 1;
            } else if (c == '+') {
                // Set sign as positive for addition
                sign = 1;
            } else if (c == '-') {
                // Set sign as negative for subtraction
                sign = -1;
            } else if (c == '(') {
                characters.push(result);
                characters.push(sign);
                // Reset result and sign for the expression inside the parenthesis
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result = characters.pop() * result + characters.pop();
            }
        }

        return result;
    }
}
