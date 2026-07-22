import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int m = matrix.length;    // Number of rows
        int n = matrix[0].length; // Number of columns

        int startingRow = 0;
        int endingRow = m - 1;
        int startingCol = 0;
        int endingCol = n - 1;

        // Continue traversing while there is at least one row
        // and one column remaining.
        while(startingRow <= endingRow && startingCol <= endingCol) {

            // Traverse from left to right.
            for(int col = startingCol; col <= endingCol; col++) {

                ans.add(matrix[startingRow][col]);
            }
            startingRow++;

            // Traverse from top to bottom.
            for(int row = startingRow; row <= endingRow; row++) {

                ans.add(matrix[row][endingCol]);
            }
            endingCol--;

            // Traverse from right to left.
            if(startingRow <= endingRow){
                for(int col = endingCol; col >= startingCol; col--){

                    ans.add(matrix[endingRow][col]);
                }
                endingRow--;
            }

            // Traverse from bottom to top.
            if(startingCol <= endingCol){
                for(int row = endingRow; row >= startingRow; row--){

                    ans.add(matrix[row][startingCol]);
                }
                startingCol++;
            }
        }
        return ans;
    }
}