class Solution {

    int[][] directions = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int numIslands = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    numIslands++;
                    
                    dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int row, int col){

        int m = grid.length;
        int n = grid[0].length;
        if(row<0 || row>=m || col<0 || col>=n){
            return;
        }

        if(grid[row][col] == '0'){
            return;
        }
        grid[row][col]='0';

        
        for(int[] dir : directions){
            int nr = row + dir[0];
            int nc = col + dir[1];

            dfs(grid, nr, nc);
        }
    }
}