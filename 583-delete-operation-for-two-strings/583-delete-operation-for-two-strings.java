class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[2][n+1];
        dp[0][0] = 0;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i == 0 && j == 0) continue;
                if(i == 0) dp[i%2][j] = dp[i%2][j-1]+1;
                else if(j == 0) dp[i%2][j] = dp[(i-1)%2][j]+1;
                else{
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i%2][j] = dp[(i-1)%2][j-1];
                    }else{
                        dp[i%2][j] = Math.min(dp[i%2][j-1], dp[(i-1)%2][j]) + 1;
                    }
                }
            }
        }
        return dp[m%2][n];
    }
}