class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int totalRow = matrix.length;
        int totalCol = matrix[0].length;

        // Start from the top-right corner.
        int row = 0;
        int col = totalCol - 1;

        // Continue while row and column indexes are inside the matrix.
        while (row < totalRow && col >= 0) {

            int currentElement = matrix[row][col];

            // Target is found.
            if (currentElement == target) {
                return true;
            }

            // Current element is too large.
            // Move left to get a smaller element.
            else if (currentElement > target) {
                col--;
            }

            // Current element is too small.
            // Move down to get a larger element.
            else {
                row++;
            }
        }

        // Target does not exist in the matrix.
        return false;
    }
}