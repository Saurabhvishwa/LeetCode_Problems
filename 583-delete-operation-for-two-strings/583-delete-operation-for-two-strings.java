class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+2];
        dp[0][0] = 0;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i == 0 && j == 0) continue;
                if(i == 0) dp[i][j] = dp[i][j-1]+1;
                else if(j == 0) dp[i][j] = dp[i-1][j]+1;
                else{
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + 1;
                    }
                }
            }
        }
        return dp[m][n];
    }
}