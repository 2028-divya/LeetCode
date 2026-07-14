class Solution {
    public int removeDuplicates(int[] nums) {
        int write = 1;
        for (int read = 0; read < nums.length - 1; read++) {
            if (nums[read] == nums[read+1]) {
               nums[write]=nums[read]; 
            }
            else{
                 nums[write]=nums[read+1];
                 write++;
            }
        }
        return write;
    }
}
