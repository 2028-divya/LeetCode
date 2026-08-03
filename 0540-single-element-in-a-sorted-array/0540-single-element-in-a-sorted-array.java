class Solution {

    public int singleNonDuplicate(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            // Make mid even so it always points to
            // the first element of a pair.
            if (mid % 2 == 1) {
                mid--;
            }

            // Pair is complete.
            // Single element is on the right.
            if (nums[mid] == nums[mid + 1]) {
                start = mid + 2;
            }

            // Pair is broken.
            // Single element is on the left (or at mid).
            else {
                end = mid;
            }
        }

        // start == end
        // Both point to the single element.
        return nums[start];
    }
}