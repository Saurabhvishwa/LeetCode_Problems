class Solution {
     public boolean isSafe(int row, int col, char[][] sol, int n){
        for(int i=0;i<n;i++){
            if(i == row) continue;
            if(sol[i][col] == 'Q') return false;
        }
        int r = row+1, c=col+1;
        while(r<n && c<n){
            if(sol[r][c] == 'Q') return false;
            r++;
            c++;
        }
        r = row-1;
        c = col-1;
        while(r>=0 && c>=0){
            if(sol[r][c] == 'Q') return false;
            r--;
            c--;
        }
        r = row+1;
        c = col-1;
        while(r<n && c>=0){
            if(sol[r][c] == 'Q') return false;
            r++;
            c--;
        }
        r = row-1;
        c = col+1;
        while(r>=0 && c<n){
            if(sol[r][c] == 'Q') return false;
            r--;
            c++;
        }
        return true;
    }
    public void perm(int row, char[][] sol, int n, int[] count){
        if(row >= n){
            count[0]++;
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(row, i, sol, n)){
                sol[row][i] = 'Q';
                perm(row+1, sol, n, count);
                sol[row][i] = '.';
            }else continue;
        }
        return;
    }
    public int totalNQueens(int n) {
        int[] count = {0};
        char[][] sol = new char[n][n];
        perm(0, sol, n, count);
        sol = null;
        return count[0];
    }
}