class Solution {
    public int heightChecker(int[] heights) {

        // Create a copy of the original array.
        int[] expected = new int[heights.length];
        int count = 0;

        // Copy all elements into the new array.
        for (int i = 0; i < heights.length; i++) {
            expected[i] = heights[i];
        }

        // Sort the copied array using Bubble Sort.
        for(int i = 0;i < expected.length - 1; i++) {

            // Tracks whether any swap occurred in the current pass.
            boolean swapped = false;

            // Compare adjacent elements and swap if they are out of order.
            for(int j = 0;j < expected.length-i-1; j++) {
                if(expected[j] > expected[j+1]) {
                    int temp = expected[j];
                    expected[j] = expected[j+1];
                    expected[j+1] = temp;

                    swapped = true;
                }
            }

            // If no swaps occurred, the array is already sorted.
            if(!swapped) {
                break;
            }
        }

        // Count the positions where the original
        // and sorted arrays differ.
        for(int i = 0 ;i <heights.length; i++) {
            if(heights[i] != expected[i]){
                count++;
            }
        }
        
        return count;
    }
}