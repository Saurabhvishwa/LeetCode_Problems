class Solution {
    int count = 0;
    public void findWays(int[] nums, int target, int index){
        if(target == 0){
            count++;
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(nums[i] != 0 && target-nums[i]>=0){
                findWays(nums, target-nums[i], i+1);
            }
        }
    }
    public int findTargetSumWays(int[] nums, int target) {
        // int sum = 0;
        // int zeroCount = 0;
        // for(int el : nums){
        //     if(el == 0)zeroCount++;
        //     sum += el;
        // }
        // target = sum-target;
        // if(target < 0 || target%2==1) return 0;
        // findWays(nums, target/2, 0);
        // if(zeroCount>0){
        //     count *= Math.pow(2, zeroCount);
        // }
        // return count;
        int sum = 0;
        for(int x : nums)
            sum += x;
        if(((sum - target) % 2 == 1) || (target > sum))
            return 0;
        
        int n = nums.length;
        int s2 = (sum - target)/2;
        int[][] dp = new int[n + 1][s2 + 1];
        dp[0][0] = 1;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= s2; j++) {
                if(nums[i - 1] <= j)
                    dp[i][j] = dp[i-1][j] + dp[i - 1][j - nums[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][s2];
    }
}