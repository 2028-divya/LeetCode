class Solution {

    // Find the index of the largest element (pivot).
    // This divides the rotated array into two sorted halves.
    public static int findPivotIndex(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        int ans = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] > nums[nums.length-1]) {

                ans = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return ans;
    }

    // Perform Binary Search on a sorted portion of the array.
    public static int binarySearch(int[] nums,int start, int end,int target) {

        while(start <= end) {

            int mid = start + (end - start) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target) {
                start = mid + 1;
            }
            else {
                 end = mid - 1;
            }
        }

        return -1;
    }
    public int search(int[] nums, int target) {

        int pivotIndex = findPivotIndex(nums);
        int n = nums.length;

        // If the array is not rotated, search the entire array.
        if(pivotIndex == -1) {

            return binarySearch(nums, 0, n-1, target);

        }

        int leftStart = 0;
        int leftEnd = pivotIndex;

        // Check whether the target lies in the left sorted half.
        if(target >= nums[leftStart] && target <= nums[leftEnd]) {

            return binarySearch(nums, leftStart, leftEnd, target);

        }

        int rightStart = pivotIndex+1;
        int rightEnd = n-1;

        // Otherwise, search in the right sorted half.
        if (target >= nums[rightStart] && target <= nums[rightEnd]) {

           return binarySearch(nums, rightStart, rightEnd, target);
                
        }
        
        return -1;
    }
}