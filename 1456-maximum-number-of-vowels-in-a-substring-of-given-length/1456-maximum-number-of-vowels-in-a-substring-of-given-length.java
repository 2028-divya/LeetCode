class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int i = 0;
        int j = 0;
        int n = s.length();

        // First window
        for (j = 0; j < k; j++) {
            if (s.charAt(j) == 'a' || s.charAt(j) == 'e' ||
                s.charAt(j) == 'i' || s.charAt(j) == 'o' ||
                s.charAt(j) == 'u') {
                count++;
            }
        }

        int maxVowels = count;

        // Slide the window
        while (j < n) {

            // Remove outgoing character
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' ||
                s.charAt(i) == 'i' || s.charAt(i) == 'o' ||
                s.charAt(i) == 'u') {
                count--;
            }

            // Add incoming character
            if (s.charAt(j) == 'a' || s.charAt(j) == 'e' ||
                s.charAt(j) == 'i' || s.charAt(j) == 'o' ||
                s.charAt(j) == 'u') {
                count++;
            }

            maxVowels = Math.max(maxVowels, count);

            i++;
            j++;
        }

        return maxVowels;
    }
}