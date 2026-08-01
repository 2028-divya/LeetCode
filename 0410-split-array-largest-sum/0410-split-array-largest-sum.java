class Solution {

    // Check whether we can split the array into at most k subarrays
    // such that the sum of every subarray is less than or equal to mid.
    public boolean isValidSubArray(int[] nums, int k, int mid) {

        // At least one subarray is needed.
        int subArray = 1;

        // Stores the sum of the current subarray.
        int sum = 0;

        for (int num : nums) {

            // Add the current number if the subarray sum
            // does not become greater than mid.
            if (sum + num <= mid) {
                sum += num;
            }

            // Adding the current number would exceed mid.
            // Start a new subarray from the current number.
            else {
                subArray++;

                // More than k subarrays are needed,
                // so mid cannot be the answer.
                if (subArray > k) {
                    return false;
                }

                // Start the new subarray with the current number.
                sum = num;
            }
        }

        // The array can be divided into at most k valid subarrays.
        return true;
    }

    public int splitArray(int[] nums, int k) {

        int start = 0;
        int end = 0;

        for (int num : nums) {

            // The answer cannot be smaller than the largest element.
            // Every element must belong to some subarray.
            start = Math.max(start, num);

            // The maximum possible answer is the sum of all elements.
            // This happens when the entire array is one subarray.
            end += num;
        }

        // Store the minimum valid maximum subarray sum found so far.
        int ans = end;

        // Apply Binary Search on the possible answer range.
        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Check whether mid can be the maximum allowed
            // subarray sum while using at most k subarrays.
            if (isValidSubArray(nums, k, mid)) {

                // mid is a valid answer.
                ans = mid;

                // Try to find a smaller valid maximum sum.
                end = mid - 1;
            }
            else {

                // mid is too small because it requires
                // more than k subarrays.
                start = mid + 1;
            }
        }

        return ans;
    }
}