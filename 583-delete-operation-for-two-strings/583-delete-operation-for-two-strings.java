class Solution {
    public int LCS(String s1, String s2){
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[2][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i%2][j] = dp[(i-1)%2][j-1] + 1;
                else dp[i%2][j] = Math.max(dp[i%2][j-1], dp[(i-1)%2][j]);
            }
        }
        return dp[m%2][n];
    }
    public int minDistance(String word1, String word2) {
        return word1.length()+word2.length() -2*LCS(word1, word2);
    }
}