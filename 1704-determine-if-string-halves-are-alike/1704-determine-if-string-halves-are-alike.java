class Solution {
    public boolean halvesAreAlike(String s) {
        int count = 0;
        int n = s.length() / 2;

        for (int i = 0; i < n; i++) {
            if ("aeiouAEIOU".indexOf(s.charAt(i)) != -1) {
                count++;
            }

            if ("aeiouAEIOU".indexOf(s.charAt(i + n)) != -1) {
                count--;
            }
        }

        return count == 0;
    }
}