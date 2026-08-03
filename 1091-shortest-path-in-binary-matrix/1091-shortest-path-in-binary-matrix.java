class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        if(grid[0][0] == 1 || grid[m-1][n-1] == 1){
            return -1;
        }
        
        int dir[][] = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1},
            {-1,-1},
            {1,1},
            {1,-1},
            {-1,1}
        };
        q.offer(new int[]{0, 0});
        grid[0][0] = 1;
        
        int size = 0;
        int distance = 1;
        while(!q.isEmpty()){
            size = q.size();
           

            for(int i=0; i<size; i++){
                int [] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                if (r == n - 1 && c == n - 1) {
                    return distance;
                }


                for(int[] d: dir){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr < 0 || nr >= m || nc < 0 || nc >= n){
                        continue;
                    }

                    if(grid[nr][nc] == 1){
                        continue;
                    }

                    if(grid[nr][nc] == 0){
                        grid[nr][nc] = 1;
                        q.offer(new int[]{nr, nc});
                        
                    }
                }
                
            }
            distance ++;
           
        }
        
        return -1;
    }
}