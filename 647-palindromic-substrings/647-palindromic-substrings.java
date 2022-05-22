class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i] = 1;
            count++;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 2;
                count += 1;
            }
        }
        for(int k = 3;k<=n;k++){
            for(int i=0;i<n+1-k;i++){
                if(s.charAt(i) == s.charAt(i+k-1) && dp[i+1][i+k-2] != 0){
                    dp[i][i+k-1] = k;
                    count+=1;
                }
            }
        }
        return count;
    }
}