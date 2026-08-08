class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] maxReach = new int[n+1];

        for(int i=0; i<=n; i++){

            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);

            maxReach[left] = Math.max(maxReach[left], right);
        }

        int taps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for(int i=0; i<=n; i++){
            farthest = Math.max(farthest, maxReach[i]);
            if(i == currentEnd){
                if(farthest <= currentEnd){
                    return -1;
                }
            

            taps++;

            currentEnd = farthest;

            if(currentEnd >= n){
                return taps;
            }
        }
    }
        return -1;
    }
}