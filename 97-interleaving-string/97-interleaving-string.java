class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), x = s3.length();
        if((m+n) != x) return false;
        // int[][] dp = new int[m+1][n+1];
        // for(int[] k : dp) Arrays.fill(k, -1);
        // return checkInterleaveMem(s1, s2, s3, 0, 0, dp) == 0 ? false : true;
        return checkInterleaveTab(s1, s2, s3, m, n, x);
    }
    public boolean checkInterleaveTab(String s1, String s2, String s3, int l1, int l2, int x){
        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        for(int i=1;i<=l1;i++){
            if(s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0] == true) dp[i][0] = true;
        }
        for(int i=1;i<=l2;i++){
            if(s2.charAt(i-1) == s3.charAt(i-1) && dp[0][i-1] == true) dp[0][i] = true;
        }
        int index = 0;
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                index = i+j-1;
                if(s1.charAt(i-1) == s3.charAt(index) && dp[i-1][j] == true) dp[i][j] = true;
                else if(s2.charAt(j-1) == s3.charAt(index) && dp[i][j-1] == true) dp[i][j] = true;
            }
        }
        return dp[l1][l2];
    }
    // public int checkInterleaveMem(String s1, String s2, String s3, int i, int j, int[][] dp){
    //     if((i+j)>=s3.length()) return 1;
    //     if(dp[i][j] != -1) return dp[i][j];
    //     int first = 0, second = 0;
    //     if(i<s1.length() && s3.charAt(i+j) == s1.charAt(i)){
    //         first = checkInterleave(s1, s2, s3, i+1, j, dp);
    //     }
    //     if(j<s2.length() && s3.charAt(i+j) == s2.charAt(j)){
    //         second = checkInterleave(s1, s2, s3, i, j+1, dp);
    //     }
    //     return dp[i][j] = (first + second) > 0 ? 1 : 0;
    // }
}