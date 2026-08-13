class Solution {
    public int longestOnes(int[] nums, int k) {

        int n = nums.length;
        int currentCount = 0;
        int max = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {

            // Add nums[right]
            if (nums[right] == 1) {
                currentCount++;
            } 
            else { // nums[right] == 0

                if (k > 0) {
                    // Flip this 0
                    k--;
                    currentCount++;
                } 
                else {
                    // No flips left.
                    // Move left until we remove a 0.
                    while (nums[left] != 0) {
                        left++;
                        currentCount--;
                    }

                    // Remove that 0 from the window
                    left++;
                    
                }
            }

            max = Math.max(max, currentCount);
        }

        return max;
    }
}