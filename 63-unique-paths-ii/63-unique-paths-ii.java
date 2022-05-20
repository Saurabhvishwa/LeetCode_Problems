class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[0][0] == 1) return 0;
        int m = grid.length;
        int n = grid[0].length;
        if(grid[m-1][n-1] == 1) return 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    grid[i][j] = -1;
                    continue;
                }
                if(i == 0 && j == 0){
                    grid[i][j] = 1;
                }else if(i == 0){
                    if(grid[i][j-1] != -1){
                        grid[i][j] = grid[i][j-1];
                    }else{
                        grid[i][j] = 0;
                    }
                }else if(j == 0){
                    if(grid[i-1][j] != -1){
                        grid[i][j] = grid[i-1][j];
                    }else{
                        grid[i][j] = 0;
                    }
                }else{
                    if(grid[i][j-1] != -1 && grid[i-1][j] != -1){
                        grid[i][j] = grid[i-1][j] + grid[i][j-1];
                    }else if(grid[i][j-1] != -1){
                        grid[i][j] = grid[i][j-1];
                    }else if(grid[i-1][j] != -1){
                        grid[i][j] = grid[i-1][j];
                    }
                }
            }
        }
        return grid[m-1][n-1];
    }
}