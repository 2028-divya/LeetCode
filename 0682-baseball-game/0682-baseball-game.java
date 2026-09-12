class Solution {
    public int calPoints(String[] operations) {

        int n = operations.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            // "C" → Remove the last valid score
            if (operations[i].equals("C")) {
                st.pop();
            }

            // "D" → Add double of the last valid score
            else if (operations[i].equals("D")) {
                st.push(2 * st.peek());
            }

            // "+" → Add the last two valid scores
            else if (operations[i].equals("+")) {

                int top = st.pop();
                int secondTop = st.peek();

                int sum = top + secondTop;

                // Put the removed score back
                st.push(top);

                // Add the new score
                st.push(sum);
            }

            // Number → Add it as a new score
            else {
                st.push(Integer.parseInt(operations[i]));
            }
        }

        int sum = 0;

        // Add all valid scores
        while (st.size() > 0) {
            sum += st.pop();
        }

        return sum;
    }
}