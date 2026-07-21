class Solution {
    public void sortColors(int[] nums) {
        // Bubble Sort
        // After each pass, the largest unsorted element moves to its correct position.
        
        for (int i = 0; i < nums.length - 1; i++) {
            // Tracks whether any swap happened during the current pass.
            // If no swaps occur, the array is already sorted.
            boolean swapped = false;

            // Compare adjacent elements.
            // The last 'i' elements are already sorted,
            // so we don't need to compare them again.
            for (int j = 0; j < nums.length - i - 1; j++) {

                // Swap if elements are in the wrong order.
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;  

                    swapped = true;
                }
            }

            // If no swaps happened in this pass,
            // the array is already sorted.
            if (!swapped) {
                break;
            }
        }
    }
}