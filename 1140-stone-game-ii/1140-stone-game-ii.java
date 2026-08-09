class Solution {

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        // suffix[i] = sum of piles from i to n-1
        int[] suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        // dp[i][M]
        int[][] dp = new int[n + 1][n + 1];

        // Fill from right to left
        for (int i = n - 1; i >= 0; i--) {

            for (int M = 1; M <= n; M++) {

                int maxTake = Math.min(2 * M, n - i);

                for (int X = 1; X <= maxTake; X++) {

                    int newM = Math.max(M, X);

                    // Current player gets everything remaining
                    // minus what opponent can optimally get
                    int currentScore =
                            suffix[i] - dp[i + X][newM];

                    dp[i][M] = Math.max(dp[i][M], currentScore);
                }
            }
        }

        return dp[0][1];
    }
}