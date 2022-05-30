class Solution {
     private void DFS(char[][] board, int row, int col){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O')
            return;
        board[row][col] = '-';
        DFS(board, row + 1, col);
        DFS(board, row - 1, col);
        DFS(board, row, col + 1);
        DFS(board, row, col - 1);
        
    }
    public void solve(char[][] board) {
        if(board.length == 0) 
            return;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < n; i++){
            if(board[0][i] == 'O')
                DFS(board, 0, i);
            if(board[m - 1][i] == 'O')
                DFS(board, m - 1, i);
        }
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O')
                DFS(board, i, 0);
            if(board[i][n - 1] == 'O')
                DFS(board, i, n - 1);
        }
       for(int i =0; i < m; i++){
           for(int j =0; j < n; j++){
               if(board[i][j] == '-')
                   board[i][j] = 'O';
               else if(board[i][j] == 'O')
                   board[i][j] = 'X';
           }
       }
       return; 
    }
}