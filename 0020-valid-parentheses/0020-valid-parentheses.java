import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Push opening brackets into the stack.
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }

            // Handle closing brackets.
            else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();

                // Check whether the closing bracket matches the top.
                if ((ch == ')' && top == '(') ||
                    (ch == ']' && top == '[') ||
                    (ch == '}' && top == '{')) {

                    stack.pop();

                } else {
                    return false;
                }
            }
        }

        // All opening brackets must have been matched.
        return stack.isEmpty();
    }
}