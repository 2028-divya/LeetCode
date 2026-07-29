class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;
            /*
             * Compare the current element with the next element.
             *
             * If arr[mid] > arr[mid + 1], we are moving downward.
             *
             * Example:
             * 1 3 5 7 6 4
             *       ↑
             *      mid
             *
             * The peak is either at 'mid' or somewhere on its left.
             * So, keep mid and discard the right half.
             */
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            }
            /*
             * If arr[mid] < arr[mid + 1], we are still climbing upward.
             *
             * Example:
             * 1 3 5 7 9 6
             *     ↑
             *    mid
             *
             * The peak must be on the right side.
             * Since mid cannot be the peak, discard it.
             */
            else {
                start = mid + 1;
            }
        }
        /*
         * The loop stops when start == end.
         * Only one index is left in the search space,
         * so that index must be the peak.
         */
        return start;
    }
}