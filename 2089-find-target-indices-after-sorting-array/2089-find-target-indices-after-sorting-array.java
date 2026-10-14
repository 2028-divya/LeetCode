
import java.util.*;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();

        int smaller = 0;
        int equal = 0;

        // Count numbers smaller than target and equal to target
        for (int num : nums) {
            if (num < target) {
                smaller++;
            } else if (num == target) {
                equal++;
            }
        }

        // Target indices start at 'smaller'
        for (int i = 0; i < equal; i++) {
            ans.add(smaller + i);
        }

        return ans;
    }
}
