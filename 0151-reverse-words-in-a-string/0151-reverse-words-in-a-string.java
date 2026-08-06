class Solution {

    public String reverseWords(String s) {

        // Store the words in reverse order.
        StringBuilder ans = new StringBuilder();

        // Start from the last character of the string.
        int i = s.length() - 1;

        while (i >= 0) {

            // Skip all spaces before finding the next word.
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            // If no characters are left, stop the loop.
            if (i < 0) {
                break;
            }

            // i is now at the last character of the current word.
            int j = i;

            // Move j to the left until a space
            // or the beginning of the string is reached.
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }

            // Extract the current word and add it to the answer.
            // j + 1 is the starting index of the word.
            // i + 1 is excluded by substring().
            ans.append(s.substring(j + 1, i + 1));

            // Skip the spaces before the next word.
            while (j >= 0 && s.charAt(j) == ' ') {
                j--;
            }

            // Add one space only when another word is still left.
            if (j >= 0) {
                ans.append(' ');
            }

            // Continue searching for the next word from this position.
            i = j;
        }

        return ans.toString();
    }
}