class Solution {

    int[] dp = new int[100001];

    public boolean winnerSquareGame(int n) {

        Arrays.fill(dp, -1);

        return helper(n) == 1;
    }

    private int helper(int n) {

        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        for (int i = 1; i * i <= n; i++) {

            int val = helper(n - i * i);

            // Opponent loses
            if (val == 0) {
                dp[n] = 1;
                return 1;
            }
        }

        // No winning move
        dp[n] = 0;
        return 0;
    }
}