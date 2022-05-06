class Solution {
    public boolean safePosition(char[][] grid, int row, int col){
        if((row>=0 && row<grid.length) && (col>=0 && col<grid[0].length) && (grid[row][col] == '1')) return true;
        return false;
    }
    public void DFS(char[][] grid, int row, int col){
        int[] ROW = {0, 1, 0, -1};
        int[] COL = {1, 0, -1, 0};
        grid[row][col] = '0';
        for(int i=0;i<4;i++){
            if(safePosition(grid, row+ROW[i], col+COL[i])){
                DFS(grid, row+ROW[i], col+COL[i]);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    DFS(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}