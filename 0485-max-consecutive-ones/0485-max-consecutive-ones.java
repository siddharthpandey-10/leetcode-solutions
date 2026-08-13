class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // int n = nums.length;
        // int left = 0;
        // int max = Integer.MIN_VALUE;
        // int count = 0;
        // for(int right=0; right<n; right++){
        //     if(right == n-1 && nums[right] == 1){
        //         return max > count ? max : count+1 ;
        //     }
        //     if(nums[right] == 0){
        //         max = Math.max(max, count);
        //         count = 0;
        //     }

        //     else if(nums[right] == 1){
        //         count++;
        //     }
        // }
        // return max;

        int n = nums.length;
        int currentCount = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(nums[i] == 1){
                currentCount ++;
            }

            else{
                max = Math.max(max, currentCount);
                currentCount = 0;
            }
        }
        return Math.max(max, currentCount);
    }
}