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
    public void perm(int row, char[][] sol, List<List<String>> ans, int n){
        if(row >= n){
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(String.valueOf(sol[i]));   
            }
            ans.add(list);
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(row, i, sol, n)){
                sol[row][i] = 'Q';
                perm(row+1, sol, ans, n);
                sol[row][i] = '.';
            }else continue;
        }
        return;
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] sol = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(sol[i], '.');
        }
        List<List<String>> ans = new ArrayList<>();
        perm(0, sol, ans, n);
        return ans;
    }
}