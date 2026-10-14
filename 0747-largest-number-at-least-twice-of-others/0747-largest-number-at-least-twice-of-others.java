class Solution {
    public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        int secondMax = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                secondMax = maxIndex;
                maxIndex = i;
            } else if (secondMax == -1 || nums[i] > nums[secondMax]) {
                secondMax = i;
            }
        }

        if (nums.length == 1 || nums[maxIndex] >= 2 * nums[secondMax]) {
            return maxIndex;
        }

        return -1;
    }
}