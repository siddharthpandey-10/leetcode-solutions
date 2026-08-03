class Solution {

    int[][] dir = {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int j=0; j<n; j++){
            if(board[0][j] == 'O'){
                
                dfs(board, 0, j);
            }
        }

        for(int j=0; j<n; j++){
            if(board[m-1][j] == 'O'){
                
                dfs(board, m-1, j);
            }
        }

        for(int j=0; j<m; j++){
            if(board[j][0] == 'O'){
                
                dfs(board, j, 0);
            }
        }

        for(int j=0; j<m; j++){
            if(board[j][n-1] == 'O'){
                
                dfs(board, j, n-1);
            }
        }

        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){

                if(board[i][j]=='O')
                    board[i][j]='X';

                else if(board[i][j]=='#')
                    board[i][j]='O';
            }
        }
    }

    private void dfs(char[][] board, int row, int col){

        int m = board.length;
        int n = board[0].length;

        if(row < 0 || row >=m || col < 0 || col >= n || board[row][col] != 'O'){
            return;
        }

        board[row][col] = '#';
        for(int [] d : dir){
            int nr = row + d[0];
            int nc = col + d[1];

            dfs(board, nr, nc);
        }
    }
}