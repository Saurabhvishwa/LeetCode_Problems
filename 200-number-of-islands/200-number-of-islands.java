class Solution {
    public boolean safePosition(char[][] grid, int row, int col, boolean[][] visited){
        if((row>=0 && row<grid.length) && (col>=0 && col<grid[0].length) && visited[row][col] == false && (grid[row][col] == '1')) return true;
        return false;
    }
    public void DFS(char[][] grid, int row, int col, boolean[][] visited){
        int[] ROW = {0, 1, 0, -1};
        int[] COL = {1, 0, -1, 0};
        visited[row][col] = true;
        for(int i=0;i<4;i++){
            if(safePosition(grid, row+ROW[i], col+COL[i], visited)){
                DFS(grid, row+ROW[i], col+COL[i], visited);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    DFS(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
}