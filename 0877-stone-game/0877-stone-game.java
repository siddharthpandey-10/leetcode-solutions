class Solution {
    public boolean stoneGame(int[] piles) {
        
        int n = piles.length;
        int [][] dp = new int[n][n];
        return helper(piles, 0, n-1, dp) >= 0;
    }
    private int helper(int[] piles, int left, int right, int[][] dp){
        
        if(left == right){
            return piles[left];
        }

        if(dp[left][right] != 0){
            return dp[left][right];
        }

        int leftTake = piles[left] - helper(piles, left+1, right, dp);
        int rightTake = piles[right] - helper(piles, left, right-1, dp);

        dp[left][right] =  Math.max(leftTake, rightTake);
        return dp[left][right];
    }
}