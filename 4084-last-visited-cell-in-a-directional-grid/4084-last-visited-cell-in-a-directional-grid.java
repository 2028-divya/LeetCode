
class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int r = 0, c = 0;

        while (true) {
            visited[r][c] = true;

            int nr = r;
            int nc = c;

            switch (grid[r][c]) {
                case 'L': nc--; break;
                case 'R': nc++; break;
                case 'U': nr--; break;
                case 'D': nr++; break;
            }

            if (nr < 0 || nr >= m || nc < 0 || nc >= n
                    || visited[nr][nc]) {
                return new int[]{r, c};
            }

            r = nr;
            c = nc;
        }
    }
}
