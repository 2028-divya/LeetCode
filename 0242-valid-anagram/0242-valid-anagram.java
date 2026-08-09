class Solution {

    public boolean isAnagram(String s, String t) {

        // Anagrams must have the same number of characters.
        if (s.length() != t.length()) {
            return false;
        }

        // Stores the frequency difference of each character.
        int[] frequency = new int[26];

        // Counts how many characters currently have a non-zero frequency.
        int different = 0;

        for (int i = 0; i < s.length(); i++) {

            int first = s.charAt(i) - 'a';
            int second = t.charAt(i) - 'a';

            // If this character had no difference before,
            // adding one creates a new frequency difference.
            if (frequency[first] == 0) {
                different++;
            }

            frequency[first]++;

            // Remove the character found in t.
            frequency[second]--;

            // If its frequency becomes zero again,
            // the difference for this character has been cancelled.
            if (frequency[second] == 0) {
                different--;
            }
        }

        // different == 0 means every character has the same frequency
        // in both strings.
        return different == 0;
    }
}