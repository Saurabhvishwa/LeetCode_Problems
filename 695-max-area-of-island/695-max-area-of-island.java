class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    max = Math.max(max, bfs(grid, i, j));
                }
            }
        }
        return max;
    }
    public int bfs(int[][] grid, int row, int col){
        int count = 1;
        grid[row][col] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int r = temp[0], c = temp[1];
            if(isValid(grid, r, c+1)){
                q.add(new int[]{r, c+1});
                grid[r][c+1] = 0;
                count++;
            }
            if(isValid(grid, r+1, c)){
                q.add(new int[]{r+1, c});
                grid[r+1][c] = 0;
                count++;
            }
            if(isValid(grid, r, c-1)){
                q.add(new int[]{r, c-1});
                grid[r][c-1] = 0;
                count++;
            }
            if(isValid(grid, r-1, c)){
                q.add(new int[]{r-1, c});
                grid[r-1][c] = 0;
                count++;
            }
        }
        return count;
    }
    public boolean isValid(int[][] grid, int row, int col){
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && grid[row][col] == 1) return true;
        return false;
    }
}