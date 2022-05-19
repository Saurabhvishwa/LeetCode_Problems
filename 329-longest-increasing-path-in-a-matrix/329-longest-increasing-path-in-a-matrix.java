class Solution {
    public int max(int[] arr){
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    public int longestPath(int[][] matrix, int row, int col, int[][] dp, int m, int n){
        if(row<0 || row>=m || col<0 || col>=n) return 0;
        if(dp[row][col] != 0) return dp[row][col];
        int[] temp = new int[5];
        if(col<n-1 && matrix[row][col+1]>matrix[row][col]){
            temp[0] = dp[row][col] + 1 + longestPath(matrix, row, col+1, dp, m, n);
        }
        if(row<m-1 && matrix[row+1][col]>matrix[row][col]){
            temp[1] = dp[row][col] + 1 + longestPath(matrix, row+1, col, dp, m, n);
        }
        if(col>0 && matrix[row][col-1]>matrix[row][col]){
            temp[2] = dp[row][col] + 1 + longestPath(matrix, row, col-1, dp, m, n);
        }
        if(row>0 && matrix[row-1][col]>matrix[row][col]){
            temp[3] = dp[row][col] + 1 + longestPath(matrix, row-1, col, dp, m, n);
        }
        temp[4] = 1;
        return dp[row][col] = max(temp);
    }
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j] == 0){
                    longestPath(matrix, i, j, dp, m, n);
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}