class Solution {
    public void DFS(char[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col<0 || col>=grid[0].length) return;
        if(grid[row][col] == '0') return;
        grid[row][col] = '0';
        
        DFS(grid, row, col+1);
        DFS(grid, row+1, col);
        DFS(grid, row, col-1);
        DFS(grid, row-1, col);
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