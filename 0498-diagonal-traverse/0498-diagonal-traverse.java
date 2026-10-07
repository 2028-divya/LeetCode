class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[] ans = new int[n * m];

        int i = 0;
        int j = 0;
        int index = 0;

        while (index < n * m) {

            // Even diagonal -> upward
            if ((i + j) % 2 == 0) {

                while (i >= 0 && j < m) {
                    ans[index++] = mat[i][j];
                    i--;
                    j++;
                }

                // Decide next starting position
                if (j == m) {
                    j = m - 1;
                    i += 2;
                } else {
                    i = 0;
                }

            } 
            // Odd diagonal -> downward
            else {

                while (i < n && j >= 0) {
                    ans[index++] = mat[i][j];
                    i++;
                    j--;
                }

                // Decide next starting position
                if (i == n) {
                    i = n - 1;
                    j += 2;
                } else {
                    j = 0;
                }
            }
        }

        return ans;
    }
}