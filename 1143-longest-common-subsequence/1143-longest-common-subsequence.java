class Solution {
    public int getLongestSubSequence(String a, String b){
        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i == 0 || j==0){
                    dp[i][j] = 0;
                }
                else if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        return getLongestSubSequence(text1, text2);
    }
}