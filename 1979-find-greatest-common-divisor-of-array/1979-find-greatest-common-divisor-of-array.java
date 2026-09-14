class Solution {
    public int findGCD(int[] nums) {

        int min = nums[0];
        int max = nums[0];

        // Find minimum and maximum
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }

            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // Euclidean Algorithm
        while (max % min != 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }

        return min;
    }
}