class Solution {
    static class Cell{
        int row;
        int col;
        int effort;
        public Cell(int r, int c, int e){
            this.row = r;
            this.col = c;
            this.effort = e;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;
        int[][] dp = new int[m][n];
        int[][] pos = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Cell> minHeap = new PriorityQueue<>(Comparator.comparingInt(cell -> cell.effort));
        minHeap.add(new Cell(0,0,0));
        while(!minHeap.isEmpty()){
            Cell cell = minHeap.poll();
            int dist = cell.effort;
            int row = cell.row;
            int col = cell.col;
            if(dist > dp[row][col]) continue;
            if(row == m-1 && col == n-1) break;
            for(int[] k:pos){
                int newRow = row+k[0];
                int newCol = col+k[1];
                if((newRow >=0 && newRow<m) && (newCol>=0 && newCol<n)){
                    int newDist = Math.max(dist, Math.abs(heights[row][col] - heights[newRow][newCol]));
                    if(newDist < dp[newRow][newCol]){
                        dp[newRow][newCol] = newDist;
                        minHeap.add(new Cell(newRow, newCol, newDist));
                    }
                }
            }
        }
        return dp[m-1][n-1] == Integer.MAX_VALUE ? 0 : dp[m-1][n-1];
    }
}