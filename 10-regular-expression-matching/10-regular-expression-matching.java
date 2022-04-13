class Solution {
    public boolean isMatch(String text, String pattern) {
        int m = text.length();
        int n = pattern.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[m][n] = true;
        for(int i=m;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                boolean check = (i<m) && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');
                if(j+1<n && pattern.charAt(j+1) == '*'){
                    dp[i][j] = (check && dp[i+1][j]) || dp[i][j+2];
                }else{
                    dp[i][j] = check && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}