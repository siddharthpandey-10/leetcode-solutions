class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        

        Queue<int[]> q = new LinkedList<>();

        int [][]directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int minutes = 0;
        int fresh = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1){
                    fresh ++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int size = 0;
        while(!q.isEmpty()){
            size = q.size();
            boolean rottedThisMinute = false;

            for(int i=0; i<size; i++){
                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];

                for(int[] dir : directions){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr < 0 || nr >= m || nc < 0 || nc >= n){
                        continue;
                    }

                    if(grid[nr][nc] == 2 || grid[nr][nc] == 0){
                        continue;
                    }

                    if(grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        rottedThisMinute = true;
                        q.offer(new int[]{nr, nc});
                        fresh --;
                        
                    }
                }
            }

            if(rottedThisMinute)minutes++;
            
        }
        return fresh > 0 ? -1 : minutes;
    }
}