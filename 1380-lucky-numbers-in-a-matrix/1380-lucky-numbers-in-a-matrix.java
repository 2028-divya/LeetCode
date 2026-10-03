class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] rowMin = new int[rows];
        int[] colMax = new int[cols];

        Arrays.fill(rowMin, Integer.MAX_VALUE);
        Arrays.fill(colMax, Integer.MIN_VALUE);

        // Find row minimums and column maximums
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
                colMax[j] = Math.max(colMax[j], matrix[i][j]);
            }
        }

        // Check lucky numbers
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == rowMin[i] &&
                    matrix[i][j] == colMax[j]) {
                    ans.add(matrix[i][j]);
                }
            }
        }

        return ans;
    }
}