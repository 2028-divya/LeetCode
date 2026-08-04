class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        // Treat the 2D matrix like one sorted 1D array.
        int totalElements = rows * columns;

        int start = 0;
        int end = totalElements - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Convert the imaginary 1D index into a row and column.
            int row = mid / columns;
            int column = mid % columns;

            // Access the matrix element using the calculated position.
            int midElement = matrix[row][column];

            if (midElement == target) {
                return true;
            }
            else if (midElement > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return false;
    }
}