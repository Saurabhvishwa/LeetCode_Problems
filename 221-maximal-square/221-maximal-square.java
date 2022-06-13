class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[2][n];
        int max = 1;
        boolean noOne = true;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int x = matrix[i][j] - '0';
                if(x == 1 && noOne == true) noOne = false;
                dp[i%2][j] = x;
                if( i == 0 || j == 0  || dp[i%2][j] == 0) continue;
                else{
                    int min = Math.min(dp[i%2][j-1], Math.min(dp[(i-1)%2][j], dp[(i-1)%2][j-1]));
                    dp[i%2][j] *= min+1;
                }
                if(dp[i%2][j] > max) max = dp[i%2][j];
            }
        }
        return noOne == true ? 0 : max*max;
    }
}