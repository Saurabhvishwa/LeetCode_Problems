class Solution {
    public int getLiveCells(int[][] board, int i, int j, int m, int n){
        int count = 0;
                if(j+1<n && (board[i][j+1] == 1 || board[i][j+1] == -10)) count++;
                if(i+1<m && j+1<n && (board[i+1][j+1] == 1 || board[i+1][j+1] == -10)) count++;
                if(i+1<m && (board[i+1][j] == 1|| board[i+1][j] == -10)) count++;
                if(i+1<m && j-1>=0 && (board[i+1][j-1] == 1|| board[i+1][j-1] == -10)) count++;
                if(j-1>=0 && (board[i][j-1] == 1|| board[i][j-1] == -10)) count++;
                if(i-1>=0 && j-1>=0 && (board[i-1][j-1] == 1|| board[i-1][j-1] == -10)) count++;
                if(i-1>=0 && (board[i-1][j] == 1|| board[i-1][j] == -10)) count++;
                if(i-1>=0 && j+1<n && (board[i-1][j+1] == 1|| board[i-1][j+1] == -10)) count++;
        return count;
    }
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count = getLiveCells(board, i, j, m, n);
                if(board[i][j] == 1 && count<2){
                    board[i][j] = -10;
                }else if(board[i][j] == 1 && (count == 2|| count == 3)){
                    board[i][j] = 1;
                }else if(board[i][j] == 1 && count>3){
                    board[i][j] = -10;
                }else if(board[i][j] == 0 && count == 3){
                    board[i][j] = 10;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == -10){
                    board[i][j] = 0;
                }else if(board[i][j] == 10){
                    board[i][j] = 1;
                }
            }
        }
    }
}