class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double maxAvg = Double.NEGATIVE_INFINITY;

        int i = 0;
        int j = 0;

        // First window
        for (j = 0; j < k; j++) {
            sum += nums[j];
        }

        maxAvg = sum / k;

        // Slide the window
        while (j < nums.length) {
            sum = sum + nums[j] - nums[i];

            maxAvg = Math.max(maxAvg, sum / k);

            j++;
            i++;
        }

        return maxAvg;
    }
}