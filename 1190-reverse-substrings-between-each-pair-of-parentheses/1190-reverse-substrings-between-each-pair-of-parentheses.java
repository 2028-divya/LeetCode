class Solution {
    public String reverseParentheses(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch != ')') {
                stack.push(ch);
            }

            else {

                StringBuilder temp = new StringBuilder();

                // Pop characters until '('
                while (stack.peek() != '(') {
                    temp.append(stack.pop());
                }

                // Remove '('
                stack.pop();

                // Put the already-reversed characters
                // back in the same order.
                for (int j = 0; j < temp.length(); j++) {
                    stack.push(temp.charAt(j));
                }
            }
        }

        StringBuilder result = new StringBuilder();

        // Build result from bottom to top
        for (Character ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}