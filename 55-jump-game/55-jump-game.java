class Solution {
    public boolean isReachPossible(int[] nums, int n, int[] dp){
        if(n == 1) return true;
        if(nums[0] == 0) return false;
        dp[0] = 0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]+j >= i){
                    if(dp[j] == Integer.MAX_VALUE){
                        dp[i] = Math.min(dp[i], dp[j]);
                    }else{
                        dp[i] = Math.min(dp[i], 1+dp[j]);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1] != Integer.MAX_VALUE;
    }
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return isReachPossible(nums, nums.length, dp);
    }
}