class Solution {

    // Checks if substring from i to j is a palindrome
    public boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        // Compare characters from both ends
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {

                // Skip either the left or right character
                return isPalindrome(i + 1, j, s)
                    || isPalindrome(i, j - 1, s);
            }

            i++;
            j--;
        }

        return true;
    }
}