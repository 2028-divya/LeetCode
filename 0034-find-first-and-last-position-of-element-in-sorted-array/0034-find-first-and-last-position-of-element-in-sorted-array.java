class Solution {
    public static int getFirstOccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // Stores the first occurrence index.
        // Remains -1 if the target is not found.
        int answer = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {

                // Store the current index.
                answer = mid;

            // Continue searching on the left
            // to find an earlier occurrence.
                end = mid - 1;
            }
            else if (arr[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return answer;
    }
    public static int getLastOccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // Stores the last occurrence index.
        // Remains -1 if the target is not found.
        int answer = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {

                // Store the current index.
                answer = mid;

                // Continue searching on the right
                // to find a later occurrence
                start = mid + 1;
            }
            else if (arr[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return answer;
    }

    public int[] searchRange(int[] nums, int target) {

        // Returns the first and last occurrence of the target.
        int[] result = {getFirstOccurrence(nums, target), getLastOccurrence(nums, target)};
        return result;
    }
}