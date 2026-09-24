class Solution {

    // Returns sum of digits
    public int digitSum(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    public int smallestIndex(int[] nums) {

        // Check each index
        for (int index = 0; index < nums.length; index++) {
            if (index == digitSum(nums[index])) {
                return index;
            }
        }

        return -1;
    }
}