class Solution {

    // Find the index of the largest element (pivot).
    public static int findPivotIndex(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[nums.length - 1]) {
                ans = mid;
                start = mid + 1;
            } 
            else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public int findMin(int[] nums) {

        int pivotIndex = findPivotIndex(nums);

        // Minimum is just after the pivot.
        if (pivotIndex != -1) {
            return nums[pivotIndex + 1];
        }

        // Array is not rotated, so the minimum is at index 0.
        return nums[0];
    }
}