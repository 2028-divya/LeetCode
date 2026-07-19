class Solution {
    public int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
        return new int[0][0];
}
        int[][] transpose = new int[matrix[0].length][matrix.length];

        for (int row = 0; row < matrix[0].length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                transpose[row][column] = matrix[column][row];
            }
        }
        
        return transpose;
    }
}