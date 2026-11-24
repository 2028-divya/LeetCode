class Solution {
    public int maxLength(List<String> arr) {
        return solve(arr, 0, 0);
    }

    private int solve(List<String> arr, int index, int mask) {
        if (index == arr.size()) {
            return Integer.bitCount(mask);
        }

        int max = solve(arr, index + 1, mask);

        int newMask = 0;
        String s = arr.get(index);

        for (char ch : s.toCharArray()) {
            int bit = 1 << (ch - 'a');

            if ((newMask & bit) != 0 || (mask & bit) != 0) {
                return max;
            }

            newMask |= bit;
        }

        return Math.max(max, solve(arr, index + 1, mask | newMask));
    }
}