import java.util.*;

class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;

        // Sort even indices in ascending order
        for (int i = 0; i < n - 2; i += 2) {
            for (int j = 0; j < n - 2; j += 2) {
                if (nums[j] > nums[j + 2]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 2];
                    nums[j + 2] = temp;
                }
            }
        }

        // Sort odd indices in descending order
        for (int i = 1; i < n - 2; i += 2) {
            for (int j = 1; j < n - 2; j += 2) {
                if (nums[j] < nums[j + 2]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 2];
                    nums[j + 2] = temp;
                }
            }
        }

        return nums;
    }
}