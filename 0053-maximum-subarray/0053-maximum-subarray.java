class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            // Step 1: Create Sum.
            sum = sum + nums[i];
            // Step 2: Update Maximum.
            if(sum > maxSum){
                maxSum = sum;
            }
            // Step 3: Check The Sum For Negative Value.
            if(sum < 0){
                sum = 0;
            }
        }
        // Return the Maximum value.
        return maxSum;
    }
}