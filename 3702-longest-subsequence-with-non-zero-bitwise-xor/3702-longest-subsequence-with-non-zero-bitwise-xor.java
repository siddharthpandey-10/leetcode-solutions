class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int totalXOR = 0;
        boolean allZeroes = true;

        for(int num : nums){
            totalXOR ^= num;

            if(num > 0) allZeroes = false;

        }

        if(totalXOR > 0){
            return n;
        }

        return allZeroes ? 0 : n-1;
    }
}