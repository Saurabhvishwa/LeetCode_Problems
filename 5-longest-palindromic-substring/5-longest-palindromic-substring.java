class Solution {
    public String longestPalindrome(String s) {
        if(s.equals("") || s == null){
            return "";
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i] = true;
        }
        int max = 1;
        int start = 0;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                start = i;
                max = 2;
            }
        }
        for(int k=2;k<=n;k++){
            for(int i=0;i<n-k+1;i++){
                int j = i+k-1;
                if(dp[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    if(k>max){
                        start = i;
                        max = k;
                    }
                }
            }
        }
        return s.substring(start, start+max);
    }
}