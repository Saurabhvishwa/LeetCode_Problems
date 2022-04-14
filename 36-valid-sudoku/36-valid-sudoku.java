class Solution {
    public boolean CheckInRow(char[][] board, int row){
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<board.length;i++){
            if(board[row][i] == '.') continue;
            if(set.contains(board[row][i])) return false;
            else set.add(board[row][i]);
            
        }
        return true;
    }
    public boolean CheckInCol(char[][] board, int col){
         HashSet<Character> set = new HashSet<>();
        for(int i=0;i<board.length;i++){
            if(board[i][col] == '.') continue;
            else if(set.contains(board[i][col])) return false;
            else set.add(board[i][col]);
        }
        return true;
    }
    public boolean CheckInBox(char[][] board, int row, int col){
         HashSet<Character> set = new HashSet<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[row+i][col+j] == '.') continue;
                else if(set.contains(board[i+row][j+col])) return false;
                else set.add(board[i+row][j+col]);
            }
        }
        return true;
    }
    public boolean isValidSection(char[][] board, int i, int j){
        return CheckInRow(board, i) && CheckInCol(board, j) && CheckInBox(board, i-i%3, j-j%3);
    }
    public boolean isValid(char[][] board, int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!isValidSection(board, i, j)) return false;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        if(isValid(board, n)) return true;
        else return false;
    }
}