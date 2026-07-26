class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        // Continue searching while the search space is valid.
        while(start <= end) {

            // Calculate the middle index safely to avoid integer overflow.
            int mid = start + ((end - start) / 2);

            // Target found.
            if(nums[mid] == target) {
               return mid;
            }

            // Search in the right half.
            else if (target > nums[mid]) {
                start = mid + 1;
            }

            // Search in the left half.
            else {
                end = mid - 1;
            }
        }

        // Target does not exist in the array.
        return -1;
    }
}