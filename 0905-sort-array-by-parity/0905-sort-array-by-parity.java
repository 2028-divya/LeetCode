class Solution {
    public int[] sortArrayByParity(int[] nums) {

        // 'write' points to the next position
        // where an even number should be placed.
        int write = 0;

         // 'read' scans every element in the array.
        for(int read = 0; read < nums.length; read++) {

            // If the current element is even,
            // move it to the front of the array.
            if(nums[read] % 2 == 0) {

                int temp = nums[read];
                nums[read] = nums[write];
                nums[write] = temp;
                
                // Move to the next position for the next even number.
                write++;
            }
        }
        return nums;
    }
}