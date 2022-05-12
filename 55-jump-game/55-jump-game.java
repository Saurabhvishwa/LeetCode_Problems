class Solution {
    public boolean isReachPossible(int[] nums, int n, int[] dp){
        if(n == 1) return true;
        if(nums[0] == 0) return false;
        // dp[0] = 0;
        // for(int i=1;i<n;i++){
        //     for(int j=0;j<i;j++){
        //         if(nums[j]+j >= i){
        //             if(dp[j] == Integer.MAX_VALUE){
        //                 dp[i] = Math.min(dp[i], dp[j]);
        //             }else{
        //                 dp[i] = Math.min(dp[i], 1+dp[j]);
        //             }
        //         }
        //     }
        // }
        // return dp[n-1] != Integer.MAX_VALUE;
        int max = nums[0];
        for(int i=0;i<n;i++){
            if(max <= i && nums[i] == 0){
                return false;
            }
            if(i+nums[i] > max){
                max = i+nums[i];
            }
            if(max >= n-1) return true;
        }
        return true;
    }
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return isReachPossible(nums, nums.length, dp);
    }
}