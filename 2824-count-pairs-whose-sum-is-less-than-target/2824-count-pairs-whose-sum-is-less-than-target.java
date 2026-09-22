class Solution {
    public int countPairs(List<Integer> nums, int target) {

        // Sort the list so that we can use the two-pointer approach
        Collections.sort(nums);

        int left = 0;
        int right = nums.size() - 1;

        int pairCount = 0;

        while (left < right) {

            int sum = nums.get(left) + nums.get(right);

            if (sum < target) {

                // Since nums is sorted:
                // nums[left] + nums[right] < target
                // So nums[left] can form a valid pair
                // with every element from left+1 to right.
                //
                // Number of such pairs = right - left
                pairCount = pairCount + (right - left);

                // Move left forward to find more pairs
                left = left + 1;

            } else {

                // Sum is too large, so decrease the larger value
                right = right - 1;
            }
        }

        return pairCount;
    }
}