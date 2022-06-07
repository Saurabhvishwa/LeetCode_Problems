class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i%2][1] = dp[(i-1)%2][0]+nums[i];
            dp[i%2][0] = Math.max(dp[(i-1)%2][0], dp[(i-1)%2][1]);
        }
        return Math.max(dp[(nums.length-1)%2][0], dp[(nums.length-1)%2][1]);
    }
}