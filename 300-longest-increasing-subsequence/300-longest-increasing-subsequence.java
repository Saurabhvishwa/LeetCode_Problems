class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i=0;i<dp.length;i++){
            dp[i] = 1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(1+dp[j], dp[i]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i:dp){
            max = Math.max(max, i);
        }
        return max;
    }
}