class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int[] result = new int[nums.length];

        // Two pointers: start and end of the array
        int left = 0;
        int right = nums.length - 1;

        // Fill result from the end (largest square first)
        int index = nums.length - 1;

        while (left <= right) {

            // Compare absolute values because the larger
            // absolute value will produce the larger square
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[index] = nums[left] * nums[left];
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                right--;
            }

            index--;
        }

        return result;
    }
}