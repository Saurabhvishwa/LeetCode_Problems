class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), x = s3.length();
        if((m+n) != x) return false;
        int[][] dp = new int[m+1][n+1];
        for(int[] k : dp) Arrays.fill(k, -1);
        return checkInterleave(s1, s2, s3, 0, 0, dp) == 0 ? false : true;
    }
    public int checkInterleave(String s1, String s2, String s3, int i, int j, int[][] dp){
        if((i+j)>=s3.length()) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        int first = 0, second = 0;
        if(i<s1.length() && s3.charAt(i+j) == s1.charAt(i)){
            first = checkInterleave(s1, s2, s3, i+1, j, dp);
        }
        if(j<s2.length() && s3.charAt(i+j) == s2.charAt(j)){
            second = checkInterleave(s1, s2, s3, i, j+1, dp);
        }
        return dp[i][j] = (first + second) > 0 ? 1 : 0;
    }
}