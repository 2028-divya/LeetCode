class Solution {
    public int[] plusOne(int[] digits) {

        // Traverse from right to left
        for (int i = digits.length - 1; i >= 0; i--) {

            // If current digit is not 9, just increment it
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }

            // 9 + 1 = 0, carry goes to the next digit
            digits[i] = 0;
        }

        // All digits were 9, so we need an extra digit
        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
}