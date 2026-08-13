import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();

        // Put all elements of nums1 into the set
        for (int num : nums1) {
            set.add(num);
        }

        // Store common elements
        HashSet<Integer> ans = new HashSet<>();

        for (int num : nums2) {
            if (set.contains(num)) {
                ans.add(num);
            }
        }

        // Convert HashSet to int[]
        int[] result = new int[ans.size()];

        int i = 0;
        for (int num : ans) {
            result[i] = num;
            i++;
        }

        return result;
    }
}