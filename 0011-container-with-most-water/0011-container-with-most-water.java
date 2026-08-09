class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;

        int area = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            int min = Math.min(height[left], height[right]);
            int width = right - left ;
            int newArea = min * width;
            if(area < newArea ){
                area = newArea;
            }

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return area;
    }
}