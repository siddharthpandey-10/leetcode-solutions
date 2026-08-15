class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int used = 0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(fruits[i] <= baskets[j]){
                    if(!visited[j]){
                        visited[j] = true;
                        used++;
                        break;
                    }
                }
            }
        }
        
        return n - used;
    }
}