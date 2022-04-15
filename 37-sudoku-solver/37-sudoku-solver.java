class Solution {
    public boolean checkInRow(char[][] board, int row, int col, char num){
        for(int i=0;i<9;i++){
            if(i == col) continue;
            if(board[row][i] == num) return false;
        }
        return true;
    }
    public boolean checkInCol(char[][] board, int row, int col, char num){
        for(int i=0;i<9;i++){
            if(i == row) continue;
            if(board[i][col] == num) return false;
        }
        return true;
    }
    public boolean checkInBox(char[][] board, int x, int y, int row, int col, char num){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i == x && j == y) continue;
                if(board[i+row][j+col] == num) return false;
            }
            
        }
        return true;
    }
    public boolean isValidChar(char[][] board, int row, int col, char num){
        return checkInRow(board, row, col, num) && checkInCol(board, row, col, num) && checkInBox(board, row, col, row-row%3, col-col%3, num);
    }
    public boolean solve(char[][] board, int n){
        int row = -1;
        int col = -1;
        boolean empty = true;
      for(int i=0;i<n;i++){
          for(int j=0;j<n;j++){
              if(board[i][j] == '.'){
                  row = i;
                  col = j;
                  empty = false;
                  break;
              }
          }
      }
        if(empty) return true;
        for(char c='1';c<='9';c++){
            if(isValidChar(board, row, col, c)){
                board[row][col] = c;
                if(solve(board, n)){
                    return true;
                }else{
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
       solve(board, board.length);
    }
}