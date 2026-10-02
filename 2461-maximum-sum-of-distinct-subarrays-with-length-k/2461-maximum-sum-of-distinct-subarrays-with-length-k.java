class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        long sum = 0;
        long maxSum = 0;

        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            // Add current element
            sum += nums[right];
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            // Keep window size <= k
            if (right - left + 1 > k) {
                sum -= nums[left];

                freq.put(nums[left], freq.get(nums[left]) - 1);

                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }

                left++;
            }

            // Window size k and all elements are distinct
            if (right - left + 1 == k && freq.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}