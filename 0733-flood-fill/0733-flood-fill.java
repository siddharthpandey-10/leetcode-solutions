class Solution {
    int [][] directions = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        if(originalColor == color){
            return image;
        }
        
        dfs(image, sr, sc, originalColor, color);
        return image;
    }

    private void dfs(int[][]image, int row, int col, int originalColor, int color){
        
        int m = image.length;
        int n = image[0].length;
        
        if(row<0 || row>=m || col<0 || col>=n){
            return;
        }

        if(image[row][col] != originalColor){
            return;
        }

        image[row][col] = color;

        for(int[] dir : directions){

            int nr = row + dir[0];
            int nc = col + dir[1];

            dfs(image, nr, nc, originalColor, color);
        }
        
    }
}