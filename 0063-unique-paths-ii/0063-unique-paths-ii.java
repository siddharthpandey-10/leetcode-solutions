class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        // Initialize with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(obstacleGrid, 0, 0, dp);
    }

    public int solve(int[][] grid, int i, int j, int[][] dp) {

        int m = grid.length;
        int n = grid[0].length;

        // Out of bounds
        if (i >= m || j >= n) {
            return 0;
        }

        // Obstacle
        if (grid[i][j] == 1) {
            return 0;
        }

        // Reached destination
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Store and return answer
        dp[i][j] = solve(grid, i + 1, j, dp)
                 + solve(grid, i, j + 1, dp);

        return dp[i][j];
    }
}