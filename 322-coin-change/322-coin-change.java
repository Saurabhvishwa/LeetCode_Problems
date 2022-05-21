class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        // Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int c : coins){
                if(i == c){
                    dp[i] = 1;
                }else if(i > c){
                    if(dp[i-c] == Integer.MAX_VALUE) continue;
                    else dp[i] = Math.min(dp[i], 1 + dp[i-c]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}