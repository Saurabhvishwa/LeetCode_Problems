class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0){
                    dp[j] = 1;
                }else if(j>0){
                    dp[j] = dp[j] + dp[j-1];
                }
            }
        System.out.println(Arrays.toString(dp));
        }
        return dp[n-1];
    }
}